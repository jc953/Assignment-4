package a4;

import java.util.ArrayList;

public class Update implements Node {
	Command command;
	Token tok;
	Expression e1, e2;

	public Update(Expression e1, Expression e2) {
		this.e1 = e1;
		this.e1.setParent(this);
		this.e2 = e2;
		this.e2.setParent(this);
		tok = new Token(0, 0);
	}
	
	public Program getProgram(){
		return command.getProgram();
	}
	
	public void addCommand(Command c){
		command = c;
	}
	
	public Command getCommand(){
		return command;
	}
	
	public Expression getExpression1(){
		return e1;
	}
	
	public Expression getExpression2(){
		return e2;
	}
	
	public void setExpression1(Expression e1){
		this.e1 = e1;
		this.e1.setParent(this);
	}
	
	public void setExpression2(Expression e2){
		this.e2 = e2;
		this.e2.setParent(this);
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
	
	public ArrayList<Node> getNodes(){
		ArrayList<Node> result = new ArrayList<Node>();
		result.add(this);
		ArrayList<Node> temp1 = e1.getNodes();
		ArrayList<Node> temp2 = e2.getNodes();
 		for (Node n : temp1){
			result.add(n);
		}
 		for (Node n : temp2){
 			result.add(n);
 		}
		return result;
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
