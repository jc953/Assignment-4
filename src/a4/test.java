package a4;

import java.io.*;

public class test {
	public static void main(String[] args) {
		ParserImpl p = new ParserImpl(); 
		System.out.println("w"); 
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		Reader r = new StringReader("5 < 6 --> wait"); 
		p.parse(r);
		 
		System.out.println("what");
	}
}
