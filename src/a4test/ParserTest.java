package a4test;
import a4.*;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

public class ParserTest {
	/**
	 * Test cases for Expressions
	 */
	public void testA(){
		ParserImpl p = new ParserImpl(); 
		Reader r = new StringReader("3");
		assertTrue(p.parse(r).toString()=="3");
	}
	
	/**
	 * Test cases for Conditions
	 */
	public void testB(){
		
	}
	
	/**
	 * Test cases for Commands
	 */
	public void testC(){
		
	}
	
	/**
	 * Test cases for Rules
	 */
	public void testD(){
		
	}
	
	/**
	 * Test cases for Programs
	 */
	public void testE(){
		
	}

}