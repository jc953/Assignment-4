package a4;

import java.util.ArrayList;

/**
 * A representation of a binary Boolean condition: 'and' or 'or'
 * 
 */
public class BinaryCondition extends Condition {
	protected Condition left, right;

	/**
	 * Create an AST representation of l op r.
	 * 
	 * @param l
	 * @param op
	 * @param r
	 */
	public BinaryCondition(Condition left, Token tok, Condition right) {
		this.left = left;
		this.tok = tok;
		this.right = right;
	}
	
	public Condition getRight(){
		return right;
	}
	
	public Condition getLeft(){
		return left;
	}
	
	public void setRight(Condition c){
		right = c;
	}
	
	public void setLeft(Condition c){
		left = c;
	}

	public Object getHead(){
		if (rhead != null){
			return rhead;
		}
		return head;
	}
	
	public void remove(Condition c){
		if (left.equals(c)){
			left = null;
		}
	}
	
	public ArrayList<BinaryCondition> getBinaryConditions(){
		ArrayList<BinaryCondition> result = new ArrayList<BinaryCondition>();
		if (left instanceof BinaryCondition){
			BinaryCondition tempLeft = (BinaryCondition)left;
			result.add(tempLeft);
			ArrayList<BinaryCondition> temp = tempLeft.getBinaryConditions();
			for (BinaryCondition bc : temp){
				result.add(bc);
			}
		} 
		if (right instanceof BinaryCondition){
			BinaryCondition tempRight = (BinaryCondition)right;
			result.add(tempRight);
			ArrayList<BinaryCondition> temp = tempRight.getBinaryConditions();
			for (BinaryCondition bc : temp){
				result.add(bc);
			}
		} 
		return result;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public Node mutate() {
		double r = Math.random();
		if (r < 1.0/6.0){
			double i = Math.random();
			Condition c1;
			if (i<0.5){
				c1 = left;
			} else {
				c1 = right;
			}
			Object o = getHead();
			if (o instanceof BinaryCondition){
				BinaryCondition c2 = (BinaryCondition)o;
				if ((c2.getLeft()).equals(this)){
					c2.setLeft(c1);
				} else {
					c2.setRight(c1);
				}
			} else {
				Rule rule = (Rule)o;
				rule.setCondition(c1);
			}
			return getProgram();
		} else if (r < 1.0/3.0){
			Condition c = left;
			left = right;
			right = c;
			return getProgram();
		} else if (r < 0.5){
			Object o = getHead();
			while (o instanceof BinaryCondition){
				o = ((BinaryCondition) o).getHead();
			}
			BinaryCondition top = (BinaryCondition) ((Rule)o).getCondition();
			ArrayList<BinaryCondition> conditions = top.getBinaryConditions();
			int index = (int) (Math.random()*conditions.size());
			if (getHead() instanceof Rule){
				((Rule) getHead()).setCondition(conditions.get(index));
			} else {
				BinaryCondition bc = (BinaryCondition) getHead();
				if ((bc.getLeft()).equals(this)){
					bc.setLeft(conditions.get(index));
				} else {
					bc.setRight(conditions.get(index));
				}
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			double i = Math.random();
			if (i < 0.5){
				tok = new Token(30, 0);
			} else {
				tok = new Token(31, 0);
			}
			return getProgram();
		} else if (r < 5.0 / 6.0){
			return this;//This is counting for mutation 3 and 4 as well
		} else {
		}
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		if(brace){
			System.out.print(" {");
		}
		left.prettyPrint(sb);
		System.out.print(" " + tok.toString());
		right.prettyPrint(sb);
		if(brace){
			System.out.print(" }");
		}
	}

}
