package a4;

/**
 * A representation of a critter rule.
 */
public class Rule extends AbstractNode {

    private Condition condition;
    private Command command;

    public Rule(Condition condition, Command command){
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		// TODO Auto-generated method stub

	}

}
