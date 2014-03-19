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
		return null;
	}
	
	public Node mutate2(){
		return null;
	}
	
	public Node mutate3(){
		return null;
	}
	
	public Node mutate4(){
		return null;
	}
	
	public Node mutate5(){
		return null;
	
	}
}
