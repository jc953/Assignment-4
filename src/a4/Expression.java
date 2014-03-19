package a4;

import java.util.ArrayList;
import java.util.Random;

// A critter program expression that has an integer value.
public class Expression implements Node {
	Token tok;
	boolean paren;
	Object head;

	public Expression(Token tok) {
		this.tok = tok;
		paren = false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<Expression> getExpressions(){
		ArrayList<Expression> result = new ArrayList<Expression>();
		result.add(this);
		return result;
	}

	protected Token getRandomToken(){
		if (tok.getType() == Token.NUM){
			Random r = new Random();
			((NumToken) tok).setValue(Integer.MAX_VALUE/r.nextInt());
			return tok;
		} else {
			int i = (int)(Math.random()*10);
			return new Token(10+i, 0);
		}
	}
	
	@Override
	public Node mutate() {
		if (head instanceof Update){
			return mutate1();
		} else if (head instanceof Command){
			return mutate2();
		} else if (head instanceof RelationCondition){
			return mutate3();
		} else {
			return mutate4();
		}
	}
	
	public Node mutate1(){
		double r = Math.random();
		Update u = (Update) head;
		if (r < 1.0/6.0){
			u.getCommand().removeUpdate(u);
			return getProgram();
		} else if (r < 1.0/3.0){
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			if (u.getExpression1().equals(this)){
				u.setExpression1(temp);
			} else {
				u.setExpression2(temp);
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public Node mutate2(){
		double r = Math.random();
		Command c = (Command) head;
		if (r < 1.0/6.0){
			c.removeAction();
			return getProgram();
		} else if (r < 1.0/3.0){
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			c.addAction(temp);
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public Node mutate3(){
		double r = Math.random();
		RelationCondition rc = (RelationCondition) head;
		if (r < 1.0/6.0){
			return getProgram();
		} else if (r < 1.0/3.0){
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			if (rc.getLeft().equals(this)){
				rc.setLeft(temp);
			} else {
				rc.setRight(temp);
			}
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public Node mutate4(){
		double r = Math.random();
		ExtendedExpression ee = (ExtendedExpression) head;
		if (r < 1.0/6.0){
			return getProgram();
		} else if (r < 1.0/3.0){
			return getProgram();
		} else if (r < 0.5){
			Expression temp = getProgram().getRandomExpression();
			ee.setExpression(temp);
			return getProgram();
		} else if (r < 2.0 / 3.0){
			tok = getRandomToken();
			return getProgram();
		} else {
			return getProgram();
		}
	}
	
	public void setParent(Object o){
		head = o;
	}

	public Program getProgram(){
		if (head instanceof Update){
			return ((Update) head).getProgram();
		} else if (head instanceof Command){
			return ((Command) head).getProgram();
		} else if (head instanceof RelationCondition){
			return ((RelationCondition) head).getProgram();
		} else {
			return ((Expression) head).getProgram();
		}
	}

	@Override
	public void prettyPrint(StringBuffer sb) {
		if (paren){
			sb.append(" ( " + tok.toString() + " )");
		}
		else{
			sb.append(" " + tok.toString());
		}
		if(sb.charAt(0)==' ') sb = sb.deleteCharAt(0);

	}
	
	public void setParen(boolean b){
		paren = b;
	}
		

}
