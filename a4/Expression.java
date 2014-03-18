package a4;

// A critter program expression that has an integer value.
public class Expression extends AbstractNode {
	Token tok;
	public Expression(Token tok){
		this.tok = tok;
	}
}
