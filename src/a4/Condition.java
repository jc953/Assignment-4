package a4;

/**
 * An interface representing a Boolean condition in a critter program.
 * 
 */
public abstract class Condition implements Node {
	boolean brace;
	Token tok;
	
	public void setBrace(boolean b){
		brace = b;
	}
}
