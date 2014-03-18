package a4;

public class ExtendedExpression extends Expression {
	Expression e;

	public ExtendedExpression(Token tok, Expression e) {
		super(tok);
		this.e = e;
	}
}
