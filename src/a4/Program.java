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
		rule.setProgram(this);
	}
	
	protected void removeRule(Rule rule){
		rules.remove(rule);
	}
	
	protected Rule getRule(int i){
		return rules.get(i);
	}

	protected int numRules(){
		return rules.size();
	}
	
	protected Condition getRandomCondition(){
		ArrayList<Condition> conditions = new ArrayList<Condition>();
		for (Rule r : rules){
			Condition c = r.getConditions();
			
		}
		return conditions.get((int) (Math.random()*conditions.size()));
	}
	
	protected BinaryCondition getRandomBinaryCondition(){
		
	}
	
	@Override
	public int size() {
		return rules.size() + 1;
	}

	@Override
	public Node mutate() {
		double r = Math.random();
		if (r < 1.0/6.0){
			return new Program();
		} else if (r < 1.0/3.0){
			int len = rules.size();
			int index1 = (int) (Math.random()*len);
			int index2 = (int) (Math.random()*len);
			Rule temp = rules.get(index1);
			rules.set(index1, rules.get(index2));
			rules.set(index2, temp);
			return this;
		} else if (r < 5.0 / 6.0){
			return this;//This is counting for mutation 3 and 4 as well
		} else {
			int len = rules.size();
			int index = (int) (Math.random()*len);
			rules.add(rules.get(index));
			return this;
		}
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		for(Rule r: rules){
			r.prettyPrint(sb);
			System.out.println(" ;");
		}

	}

}
