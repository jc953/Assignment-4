package a4;

// Represents +, -, *, /, mod
public class BinaryOp extends Expression { // need not be abstract
	private Expression left, right;

	public BinaryOp(Expression left, Token tok, Expression right) {
		super(tok);
		this.left = left;
		this.right = right;
	}
}
