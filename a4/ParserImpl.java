package a4;

import java.io.Reader;

public class ParserImpl implements Parser {

    /** The tokenizer from which input is read. */
    Tokenizer tokenizer;
    Token tok;

    public Program parse(Reader r) {
    	try {
			return parseProgram();
		} catch (SyntaxError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    	
    }

    /** Parses a program from the stream of tokens provided by the Tokenizer,
     *  consuming tokens representing the program. All following methods with
     *  a name "parseX" have the same spec except that they parse syntactic form
     *  X.
     *  @return the created AST
     *  @throws SyntaxError if there the input tokens have invalid syntax
     */
    public Program parseProgram() throws SyntaxError {
    	Program result = new Program();
        while (tokenizer.hasNext()){
        	result.addRule(parseRule());
        }
        return result;
    }
    public Rule parseRule() throws SyntaxError {
        Rule result = new Rule(parseCondition(),parseCommand());
        return result;
    }
    public Condition parseCondition() throws SyntaxError {
    	RelationCondition temp = parseRelation();
    	if (tokenizer.peek().getType() == Token.ARR){
    		return temp;
    	} 
    	return new BinaryCondition(temp, tokenizer.next(), parseCondition());
    }
    public Command parseCommand() throws SyntaxError {
    	
    }
    
    public RelationCondition parseRelation() throws SyntaxError {
    	RelationCondition result = new RelationCondition(parseExpression(), tokenizer.next(), parseExpression());
    	return result;
    }
    
    public Expression parseExpression() throws SyntaxError {
        Expression temp = parseFactor();
        if (tokenizer.peek().isAddOp() || tokenizer.peek().isMulOp()){
        	return new BinaryOp(temp, tokenizer.next(), parseExpression());
        } 
        return temp;
    }
    public Expression parseFactor() throws SyntaxError {
    	if (tokenizer.peek().getType() == Token.NUM){
    		return new Expression(tokenizer.next());
    	}
    	else if (tokenizer.peek().isSensor()){
        	Token t = tokenizer.next();
        	new ExtendedToken(t.getType(),tokenizer.getLineNo(),parseExpression());
        }
    }
    // add more as necessary...

    /** Consumes a token of the expected type. Throws a SyntaxError if the wrong kind of token is encountered. */
    public void consume(int tokenType) throws SyntaxError {
        throw new UnsupportedOperationException();
    }

}
