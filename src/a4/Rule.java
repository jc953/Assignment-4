package a4;

/**
 * A representation of a critter rule.
 */
public class Rule implements Node {
	private Program program;
	private Condition condition;
	private Command command;

	public Rule(Condition condition, Command command) {
		this.condition = condition;
		this.command = command;
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
			program.removeRule(this);
			return program;
		} else if (r < 1.0/3.0){
			int i = (int) (Math.random()*program.numRules());
			Rule temp = program.getRule(i);
			this.condition = temp.getCondition();
			this.command = temp.getCommand();
			return program;
		} else {
			return program; //counts for mutations 2 4 5 and 6
		}
	}

	protected void setProgram(Program p){
		program = p;
	}
	
	protected Condition getCondition(){
		return condition;
	}
	
	protected void setCondition(Condition c){
		condition = c;
	}
	
	protected Command getCommand(){
		return command;
	}
	
	protected Program getProgram(){
		return program;
	}
	
	@Override
	public void prettyPrint(StringBuffer sb) {
		condition.prettyPrint(sb);
		sb.append(" -->");
		command.prettyPrint(sb);
	}

}
