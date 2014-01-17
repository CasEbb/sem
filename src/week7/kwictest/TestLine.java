package week7.kwictest;

import junit.framework.TestCase;
import week5.adt.Line;
import week5.adt.Word;

public class TestLine extends TestCase {
	Line line;
	Word word1;
	Word word2;
	
	public void setUp() {
		line = new Line();
		word1 = new Word("a");
		word2 = new Word("b");
	}
	
	public void testNullLine() {
		line.add(null);
		assertNull("contains null object", line.getWords().get(0));
		line = line.shift();
		assertNull("first object is null", line.getWords().get(0));
		line.add(null);
		assertEquals("contains 2 words", 2, line.getWords().size());
		line = line.shift();
		assertNull("first object is still null", line.getWords().get(0));
	}
	
	public void testZeroLine() {
		assertEquals("contains no objects", 0, line.getWords().size());
		line = line.shift();
		assertEquals("still contains no objects", 0, line.getWords().size());
	}
	
	public void testOneLine() {
		line.add(word1);
		assertEquals("contains one object", 1, line.getWords().size());
		Line newLine = line.shift();
		assertEquals("didn't change after shift", newLine, line);
	}
	
	public void testMultipleLine() {
		line.add(word1);
		line.add(word2);
		assertEquals("contains two words", 2, line.getWords().size());
		Line newLine = line.shift();
		assertNotSame("line shifted", newLine, line);
	}
}
