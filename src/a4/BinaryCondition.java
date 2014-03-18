package a4;

/**
 * A representation of a binary Boolean condition: 'and' or 'or'
 * 
 */
public class BinaryCondition extends Condition {
	Condition left, right;

	/**
	 * Create an AST representation of l op r.
	 * 
	 * @param l
	 * @param op
	 * @param r
	 */
	public BinaryCondition(Condition left, Token tok, Condition right) {
		this.left = left;
		this.tok = tok;
		this.right = right;
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
		left.prettyPrint(sb);
		System.out.print(" " + tok.toString());
		right.prettyPrint(sb);
		if(brace){
			System.out.print(" }");
		}
	}

}
