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
	
	public void setHead(Object o){
		if (o instanceof Rule){
			rhead = (Rule) o;
			head = null;
		} else {
			head = (Condition) o;
			rhead = null;
		}
	}
	
	public void remove(Condition c){
		if (left.equals(c)){
			left = null;
		}
	}
	
	public BinaryCondition getRandomBinaryCondition(){
		Object o = getHead();
		while (o instanceof BinaryCondition){
			o = ((BinaryCondition) o).getHead();
		}
		BinaryCondition top = (BinaryCondition) ((Rule)o).getCondition();
		ArrayList<BinaryCondition> conditions = top.getBinaryConditions();
		return conditions.get((int) (Math.random()*conditions.size()));
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
	
	public Token getRandomToken(){
		int i = (int)(Math.random()*2);
		return new Token(30+i, 0);
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
			BinaryCondition temp = getRandomBinaryCondition();
			if (getHead() instanceof Rule){
				((Rule) getHead()).setCondition(temp);
			} else {
				BinaryCondition bc = (BinaryCondition) getHead();
				if ((bc.getLeft()).equals(this)){
					bc.setLeft(temp);
				} else {
					bc.setRight(temp);
				}
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else if (r < 5.0 / 6.0){
			Token tempTok = getRandomToken();
			BinaryCondition temp = getRandomBinaryCondition();
			Object o = getHead();
			BinaryCondition temp2 = new BinaryCondition(this, tempTok, temp);
			setHead(temp2);
			if (o instanceof BinaryCondition){
				BinaryCondition header = (BinaryCondition) o;
				temp2.setHead(header);
				if (header.getLeft().equals(this)){
					header.setLeft(temp2);
				} else {
					header.setRight(temp2);
				}
				return getProgram();
			} else {
				Rule header = (Rule) o;
				temp2.setHead(header);
				header.setCondition(temp2);
				return getProgram();
			}
		} else {
			return getProgram();
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
