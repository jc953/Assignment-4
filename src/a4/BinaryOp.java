package a4;

import java.util.ArrayList;

// Represents +, -, *, /, mod
public class BinaryOp extends Expression { // need not be abstract
	private Expression left, right;

	public BinaryOp(Expression left, Token tok, Expression right) {
		super(tok);
		this.left = left;
		this.right = right;
		this.left.setParent(this);
		this.right.setParent(this);
	}
	
	public ArrayList<Expression> getExpressions(){
		ArrayList<Expression> result = new ArrayList<Expression>();
		result.add(this);
		ArrayList<Expression> temp1 = left.getExpressions();
		ArrayList<Expression> temp2 = right.getExpressions();
		for (Expression e : temp1){
			result.add(e);
		}
		for (Expression e : temp2){
			result.add(e);
		}
		return result;
	}
	
	public Token getRandomToken(){
		int i = (int)(Math.random()*5);
		if (i < 2){
			return new Token(50 + i, 0);
		} else{
			return new Token(58 + i, 0);
		}
	}
	public void prettyPrint(StringBuffer sb) {
		if(paren){
			sb.append(" (");
		}
		left.prettyPrint(sb);
		sb.append(" " + tok.toString());
		right.prettyPrint(sb);
		if(paren){
			sb.append(" )");
		}
		if(sb.charAt(0)==' ') sb = sb.deleteCharAt(0);
	}
	
	public Node mutate1(){
		double r = Math.random();
		Update u = (Update) head;
		if (r < 1.0/6.0){
			Expression e;
			if (Math.random() < 0.5){
				e = left;
			} else{
				e = right;
			}
			if (u.getExpression1().equals(this)){
				u.setExpression1(e);
			} else {
				u.setExpression2(e);
			}
			return getProgram();
		} else if (r < 1.0/3.0){
			Expression temp = left;
			left = right;
			right = temp;
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			if (u.getExpression1().equals(this)){
				u.setExpression1(temp);
			} else {
				u.setExpression2(temp);
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public Node mutate2(){
		double r = Math.random();
		Command c = (Command) head;
		if (r < 1.0/6.0){
			Expression e;
			if (Math.random() < 0.5){
				e = left;
			} else{
				e = right;
			}
			c.addAction(e);
			return getProgram();
		} else if (r < 1.0/3.0){
			Expression temp = left;
			left = right;
			right = temp;
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			c.addAction(temp);
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public Node mutate3(){
		double r = Math.random();
		RelationCondition rc = (RelationCondition) head;
		if (r < 1.0/6.0){
			return getProgram();
		} else if (r < 1.0/3.0){
			Expression temp = left;
			left = right;
			right = temp;
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			if (rc.getLeft().equals(this)){
				rc.setLeft(temp);
			} else {
				rc.setRight(temp);
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public Node mutate4(){
		double r = Math.random();
		ExtendedExpression ee = (ExtendedExpression) head;
		if (r < 1.0/6.0){
			return getProgram();
		} else if (r < 1.0/3.0){
			Expression temp = left;
			left = right;
			right = temp;
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			ee.setExpression(temp);
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	
}
