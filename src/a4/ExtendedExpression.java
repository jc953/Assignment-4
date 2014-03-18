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
		System.out.print(" [");
		e.prettyPrint(sb);
		System.out.print(" ]");
	}
}
