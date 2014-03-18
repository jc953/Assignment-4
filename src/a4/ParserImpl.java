package a4;

import java.io.Reader;

public class ParserImpl implements Parser {

	/** The tokenizer from which input is read. */
	Tokenizer tokenizer;
	Token tok;

	public Program parse(Reader r) {
		tokenizer = new Tokenizer(r);
		try {
			return parseProgram();
		} catch (SyntaxError e) {
			System.out.println("fix this you dumb ho");
		}
		return null;

	}

	/**
	 * Parses a program from the stream of tokens provided by the Tokenizer,
	 * consuming tokens representing the program. All following methods with a
	 * name "parseX" have the same spec except that they parse syntactic form X.
	 * 
	 * @return the created AST
	 * @throws SyntaxError
	 *             if there the input tokens have invalid syntax
	 */
	public Program parseProgram() throws SyntaxError {
		Program result = new Program();
		while (tokenizer.hasNext()) {
			System.out.println("g");
			result.addRule(parseRule());
		}
		return result;
	}

	public Rule parseRule() throws SyntaxError {
		Rule result = new Rule(parseCondition(), parseCommand());
		result.getCondition().setParent(result);
		return result;
	}

	public Condition parseCondition() throws SyntaxError {
		Condition temp = parseRelation();
		if (tokenizer.peek().getType() == Token.ARR) {
			return temp;
		}
		return new BinaryCondition(temp, tokenizer.next(), parseCondition());
	}

	public Condition parseRelation() throws SyntaxError {
		if (tokenizer.peek().getType() == Token.LBRACE) {
			tokenizer.next();
			Condition result = parseCondition();
			tokenizer.next();
			return result;
		}
		return new RelationCondition(parseExpression(), tokenizer.next(),
				parseExpression());
	}

	public Command parseCommand() throws SyntaxError {
		Command c = new Command();
		while (tokenizer.peek().getType() == Token.MEM) {
			c.addUpdate(parseUpdate());
		}
		if (tokenizer.peek().isAction()) {
			c.addAction(parseExpression());
		}
		return c;
	}

	public Update parseUpdate() throws SyntaxError {
		ExtendedExpression f = (ExtendedExpression) parseFactor();
		tokenizer.next();
		return new Update(f, parseExpression());
	}

	public Expression parseExpression() throws SyntaxError {
		Expression e = parseFactor();
		if (tokenizer.peek().isMulOp() || tokenizer.peek().isAddOp()) {
			return new BinaryOp(e, tokenizer.next(), parseExpression());
		}
		return e;
	}

	public Expression parseFactor() throws SyntaxError {
		if (tokenizer.peek().getType() == Token.NUM) {
			return new Expression(tokenizer.next().toNumToken());
		} else if (tokenizer.peek().getType() == Token.LPAREN) {
			tokenizer.next();
			Expression e = parseExpression();
			e.setParen(true);
			tokenizer.next();
			return e;
		} else {
			Token tok = tokenizer.next();
			tokenizer.next();
			Expression e = parseExpression();
			tokenizer.next();
			return new ExtendedExpression(tok, e);
		}
	}

	/**
	 * Consumes a token of the expected type. Throws a SyntaxError if the wrong
	 * kind of token is encountered.
	 */
	public void consume(int tokenType) throws SyntaxError {
		throw new UnsupportedOperationException();
	}

}
