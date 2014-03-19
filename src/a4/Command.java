package a4;

import java.util.ArrayList;

public class Command implements Node {
	Rule rule;
	ArrayList<Update> updates;
	Expression action;

	public Command() {
		updates = new ArrayList<Update>();
		action = null;
	}

	public void addUpdate(Update u) {
		updates.add(u);
	}

	public void addAction(Expression e) {
		action = e;
	}
	
	public ArrayList<Update> getUpdates(){
		return updates;
	}
	
	public Expression getAction(){
		return action;
	}
	
	public void setParent(Rule r){
		rule = r;
	}
	
	public Program getProgram(){
		return rule.getProgram();
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
			getProgram().removeRule(rule);
			return getProgram();
		} else if (r < 1.0/3.0){
			int len = updates.size();
			int index1 = (int) (Math.random()*len);
			int index2 = (int) (Math.random()*len);
			Update temp = updates.get(index1);
			updates.set(index1, updates.get(index2));
			updates.set(index2, temp);
			return getProgram();
		} else if (r < 0.5){
			int i = (int)(getProgram().numRules() * Math.random());
			Rule random = getProgram().getRule(i);
			Command com = random.getCommand();
			this.updates = com.getUpdates();
			this.action = com.getAction();
			return getProgram();
		} else if (r < 5.0 / 6.0){
			return getProgram();
		} else {
			int len = updates.size();
			int index = (int) (Math.random()*len);
			updates.add(updates.get(index));
			return getProgram();
		}
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		for(Update u: updates){
			u.prettyPrint(sb);			
		}
		if (action != null){
			action.prettyPrint(sb);
		}

	}
}
