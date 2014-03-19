package a4;

import java.io.*;
import java.util.NoSuchElementException;


public class test {
	public static void main(String[] args) {
		ParserImpl p = new ParserImpl(); 
		Reader r = new StringReader("3 * 3 > 8 + 9 --> nearby [9]"); 
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
