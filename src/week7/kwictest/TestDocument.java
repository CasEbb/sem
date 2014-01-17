package week7.kwictest;

import junit.framework.TestCase;
import week5.adt.Document;
import week5.adt.Line;
import week5.adt.Word;

public class TestDocument extends TestCase {
	Document document;
	Line line;
	Line line2;
	
	public void setUp() {
		document = new Document();
		line = new Line();
		line.add(new Word("a"));
		line.add(new Word("b"));
		line2 = new Line();
		line2.add(new Word("c"));
		line2.add(new Word("d"));
	}
	
	public void testNullDocument() {
		document.add(null);
		assertNull("there is a null line", document.getLines().get(0));
		document.shift();
		assertNull("there is still a null line", document.getLines().get(0));
	}
	
	public void testZeroDocument() {
		assertEquals("there are no lines", 0, document.getLines().size());
		document.shift();
		assertEquals("there are still no lines", 0, document.getLines().size());
	}
	
	public void testOneDocument() {
		document.add(line);
		assertEquals("contains one object", 1, document.getLines().size());
		Document oldDocument = new Document();
		oldDocument.add(line);
		document.shift();
		assertNotSame("changed after shift", oldDocument, document);
		assertEquals("contains two lines after shift", 2, document.getLines().size());
	}
	
	public void testMultipleDocument() {
		document.add(line);
		document.add(line2);
		assertEquals("contains two lines", 2, document.getLines().size());
		document.shift();
		assertEquals("contains four lines", 4, document.getLines().size());
	}
}
