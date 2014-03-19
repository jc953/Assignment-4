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
			sb.append(" ( " + tok.toString() + " )");
		}
		else{
			sb.append(" " + tok.toString());
		}
		if(sb.charAt(0)==' ') sb = sb.deleteCharAt(0);

	}
	
	public void setParen(boolean b){
		paren = b;
	}
		

}
