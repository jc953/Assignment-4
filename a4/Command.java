package a4;

import java.util.ArrayList;

public class Command implements Node {
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
		

	}
}
