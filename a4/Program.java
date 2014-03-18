package a4;

import java.util.ArrayList;

/**
 * A representation of a critter program.
 * 
 */
public class Program implements Node {

	private ArrayList<Rule> rules;

	public Program() {
		rules = new ArrayList<Rule>();
	}

	protected void addRule(Rule rule) {
		rules.add(rule);
	}

	@Override
	public int size() {
		return rules.size() + 1;
	}

	@Override
	public Node mutate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prettyPrint(StringBuffer sb) {

	}

}
