package a4;

// A critter program expression that has an integer value.
public class Expression implements Node {
	Token tok;
	public Expression(Token tok){
		this.tok = tok;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Node mutate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void prettyPrint(StringBuffer sb) {
		// TODO Auto-generated method stub
		
	}
	
}
