package a4;

public class Update implements Node {
	ExtendedExpression ee;
	Expression e;

	public Update(ExtendedExpression ee, Expression e) {
		this.ee = ee;
		this.e = e;
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
