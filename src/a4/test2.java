package a4;

import java.io.Reader;
import java.io.StringReader;

public class test2 {
	public static void main(String[] args){
		ParserImpl p = new ParserImpl(); 
		Reader r = new StringReader("3 * 3 < 4 --> wait"); 
		StringBuffer sb = new StringBuffer();
		Program test = p.parse(r);
		test.mutate();
		test.mutate();
		test.prettyPrint(sb);
		System.out.println(sb.toString());

		 
	}
}
