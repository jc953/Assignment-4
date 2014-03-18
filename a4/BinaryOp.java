package a4;

// Represents +, -, *, /, mod
public class BinaryOp extends Expression { // need not be abstract
    private Expression left, right;
    private Token tok;
    
    public BinaryOp(Expression l, Token tok, Expression r){
    	left = l;
    	this.tok = tok;
    	right = r;
    }
}
