package a4;

public class ExtendedToken extends Token{
	Expression e;
	
	public ExtendedToken(int type, int lineNo, Expression e) {
		super(type, lineNo);
		this.e = e;
	}
}
