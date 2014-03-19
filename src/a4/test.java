package a4;

import java.io.*;
import java.util.NoSuchElementException;


public class test {
	public static void main(String[] args) {
		ParserImpl p = new ParserImpl(); 
		Reader r = new StringReader("3 + 3 * 5 OR 3 < 4 OR 34 > 7 --> forward"); 
		StringBuffer sb = new StringBuffer();
		try{
			p.parse(r).prettyPrint(sb);
			System.out.println(sb.toString());
		}
		catch (SyntaxError e){
			System.out.println("FIX");
		}
		 
	}
}
