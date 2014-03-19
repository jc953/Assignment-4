package a4;

import java.util.ArrayList;

public class ExtendedExpression extends Expression {
	Expression e;

	public ExtendedExpression(Token tok, Expression e) {
		super(tok);
		this.e = e;
		this.e.setParent(this);
	}
	
	public ArrayList<Expression> getExpressions(){
		ArrayList<Expression> result = new ArrayList<Expression>();
		result.add(this);
		ArrayList<Expression> temp = e.getExpressions();
		for (Expression e : temp){
			result.add(e);
		}
		return result;
	}
	
	@Override
	public void prettyPrint(StringBuffer sb) {
		super.prettyPrint(sb);
		sb.append(" [");
		e.prettyPrint(sb);
		sb.append(" ]");
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
