package a4;

// Represents +, -, *, /, mod
public class BinaryOp extends Expression { // need not be abstract
	private Expression left, right;

	public BinaryOp(Expression left, Token tok, Expression right) {
		super(tok);
		this.left = left;
		this.right = right;
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
}
