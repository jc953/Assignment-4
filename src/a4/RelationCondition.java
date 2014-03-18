package a4;

public class RelationCondition extends Condition {
	protected Expression e1, e2;

	public RelationCondition(Expression e1, Token tok, Expression e2) {
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
		if(brace){
			System.out.print(" {");
		}
		e1.prettyPrint(sb);
		System.out.print(" " + tok.toString());
		e2.prettyPrint(sb);
		if(brace){
			System.out.print(" }");
		}
	}

}
