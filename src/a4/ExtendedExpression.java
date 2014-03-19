package a4;

public class ExtendedExpression extends Expression {
	Expression e;

	public ExtendedExpression(Token tok, Expression e) {
		super(tok);
		this.e = e;
	}
	
	@Override
	public void prettyPrint(StringBuffer sb) {
		super.prettyPrint(sb);
		sb.append(" [");
		e.prettyPrint(sb);
		sb.append(" ]");
		if(sb.charAt(0)==' ') sb = sb.deleteCharAt(0);

	}
	
}
