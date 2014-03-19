package a4;

public class Update implements Node {
	Command command;
	Token tok;
	Expression e1, e2;

	public Update(Expression e1, Expression e2) {
		this.e1 = e2;
		this.e1 = e2;
		tok = new Token(0, 0);
	}
	
	public Program getProgram(){
		return command.getProgram();
	}
	
	public void addCommand(Command c){
		command = c;
	}
	
	public Expression getExpression1(){
		return e1;
	}
	
	public Expression getExpression2(){
		return e2;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Node mutate() {
		double r = Math.random();
		if (r < 1.0/6.0){
			command.removeUpdate(this);
			return getProgram();
		} else if (r < 1.0/3.0){
			Update temp = getProgram().getRandomUpdate();
			this.e1 = temp.getExpression1();
			this.e2 = temp.getExpression2();
			return getProgram();
		} else {
			return getProgram();
		}
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		sb.append(" mem [");
		e1.prettyPrint(sb);
		sb.append(" ] :=");
		e2.prettyPrint(sb);
		if (sb.charAt(0)==' ') sb = sb.deleteCharAt(0);
	}

}
