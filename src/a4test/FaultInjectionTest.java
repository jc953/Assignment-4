package a4test;
import a4.*;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

public class FaultInjectionTest {
	
	/**
	 * Test cases for random mutations.
	 */
	public void testA(){
		ParserImpl p = new ParserImpl(); 
		Reader r = new StringReader("3 + 3 * 5 AND 3<4 OR 34 > 7 --> mem[6] := 12 + 7 forward");
		StringBuffer sb = new StringBuffer();
		p.parse(r).prettyPrint(sb);
		assertTrue(p.parse(r).toString()=="3 + 3 * 5 AND 3<4 OR 34 > 7 --> mem[6] := 12 + 7 forward");
	}
}