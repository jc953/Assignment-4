package a4;

/**
 * An interface representing a Boolean condition in a critter program.
 * 
 */
public abstract class Condition implements Node {
	Rule rhead;
	boolean brace;
	Token tok;
	Condition head;
	
	public void setBrace(boolean b){
		brace = b;
	}
	
	public void setParent(Rule r){
		rhead = r;
	}
	
	public void setParent(Condition c){
		head = c;
	}
	
	public Object getRight(){
		return null;
	}
	
	public Object getLeft(){
		return null;
	}
	
	public void setRight(Object o){
	}
	
	public void setLeft(Object o){
	}
	
	public Program getProgram(){
		if (rhead != null){
			return rhead.getProgram();
		}
		return head.getProgram();
	}
	
	public Token getRandomToken() {
		return null;
	}
}
