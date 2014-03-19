package a4;

import java.io.Reader;
import java.io.StringReader;

public class test2 {
	public static void main(String[] args){
		ParserImpl p = new ParserImpl();
		Reader r = new StringReader("3 + 3 < 5 AND 3 < 4 OR 34 > 7 --> mem[6] := 12 + 7 forward");
		StringBuffer sb = new StringBuffer();
		Program prog = p.parse(r);
		for (int i = 0; i < 10; i++){
			prog.getRandomNode().mutate();
		}
		prog.prettyPrint(sb);
		System.out.println(sb.toString());
	}
}
