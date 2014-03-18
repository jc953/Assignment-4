package a4;

public class RelationCondition implements Condition{
	protected Expression e1, e2;
	protected Token tok;
	
	public RelationCondition(Expression e1, Token tok, Expression e2){
		this.e1 = e1;
		this.tok = tok;
		this.e2 = e2;
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
