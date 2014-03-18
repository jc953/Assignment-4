package a4;

import java.util.ArrayList;

public class RelationCondition extends Condition {
	protected Expression left, right;

	public RelationCondition(Expression left, Token tok, Expression right) {
		this.left = left;
		this.tok = tok;
		this.right = right;
	}
	
	public Object getHead(){
		if (rhead != null){
			return rhead;
		}
		return head;
	}
	


	public Token getRandomToken(){
		int i = (int)(Math.random()*6);
		return new Token(32+i, 0);
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
			Object o = getHead();
			if (o instanceof Rule){
				getProgram().removeRule((Rule) o);
				return getProgram();
			} else {
				BinaryCondition header = (BinaryCondition) o;
				if (header.getHead() instanceof Rule){
					Rule temp = (Rule) header.getHead();
					if (header.getLeft().equals(this)){
						temp.setCondition(header.getRight());
					} else {
						temp.setCondition(header.getLeft());
					}
					return getProgram();
				} else {
					BinaryCondition doubleheader = (BinaryCondition) header.getHead();
					Condition temp;
					if (header.getLeft().equals(this)){
						temp = header.getRight();
					} else {
						temp = header.getLeft();
					}
					if (doubleheader.getLeft().equals(header)){
						doubleheader.setLeft(temp);
					} else {
						doubleheader.setRight(temp);
					}
					return getProgram();
				}
			}
		} else if (r < 1.0/3.0){
			Expression e = left;
			left = right;
			right = e;
			return getProgram();
		} else if (r < 0.5){
			RelationCondition temp = getRandomRelationCondition();
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
			BinaryCondition temp = ((BinaryCondition) getHead()).getRandomBinaryCondition();
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
		e1.prettyPrint(sb);
		System.out.print(" " + tok.toString());
		e2.prettyPrint(sb);
		if(brace){
			System.out.print(" }");
		}
	}

}
