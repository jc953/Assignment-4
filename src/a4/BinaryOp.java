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
	
	public Node mutate(){
		double r = Math.random();
		if (r < 1.0/6.0){
			double i = Math.random();
			Condition c1;
			if (i<0.5){
				c1 = left;
			} else {
				c1 = right;
			}
			Object o = getHead();
			if (o instanceof BinaryCondition){
				BinaryCondition c2 = (BinaryCondition)o;
				if ((c2.getLeft()).equals(this)){
					c2.setLeft(c1);
				} else {
					c2.setRight(c1);
				}
			} else {
				Rule rule = (Rule)o;
				rule.setCondition(c1);
			}
			return getProgram();
		} else if (r < 1.0/3.0){
			Condition c = left;
			left = right;
			right = c;
			return getProgram();
		} else if (r < 0.5){
			BinaryCondition temp = getProgram().getRandomBinaryCondition();
			if (getHead() instanceof Rule){
				((Rule) getHead()).setCondition(temp);
			} else {
				BinaryCondition bc = (BinaryCondition) getHead();
				if ((bc.getLeft()).equals(this)){
					bc.setLeft(temp);
				} else {
					bc.setRight(temp);
				}
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else if (r < 5.0 / 6.0){
			Token tempTok = getRandomToken();
			BinaryCondition temp = getProgram().getRandomBinaryCondition();
			Object o = getHead();
			BinaryCondition temp2 = new BinaryCondition(this, tempTok, temp);
			setHead(temp2);
			if (o instanceof BinaryCondition){
				BinaryCondition header = (BinaryCondition) o;
				temp2.setHead(header);
				if (header.getLeft().equals(this)){
					header.setLeft(temp2);
				} else {
					header.setRight(temp2);
				}
				return getProgram();
			} else {
				Rule header = (Rule) o;
				temp2.setHead(header);
				header.setCondition(temp2);
				return getProgram();
			}
		} else {
			return getProgram();
		}
	}
}
