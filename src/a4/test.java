package a4;

import java.io.*;
import java.util.NoSuchElementException;


public class test {
	public static void main(String[] args) {
		ParserImpl p = new ParserImpl(); 
		Reader r = new StringReader("3+4 < 4+7 OR 5 < 4--> wait"); 
		Tokenizer tokenizer = new Tokenizer(r);
		try{
			p.parse(r).prettyPrint(null);
		}
		catch (SyntaxError e){
			System.out.println("FIX");
		}
		 
	}
}
