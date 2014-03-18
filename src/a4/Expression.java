package a4;

// A critter program expression that has an integer value.
public class Expression implements Node {
	Token tok;
	boolean paren;

	public Expression(Token tok) {
		this.tok = tok;
		paren = false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Node mutate() {
		return null;
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		if (paren){
			System.out.print(" ( " + tok.toString() + " )");
		}
		else{
			System.out.print(" " + tok.toString());
		}

	}
	
	public void setParen(boolean b){
		paren = b;
	}
		

}
