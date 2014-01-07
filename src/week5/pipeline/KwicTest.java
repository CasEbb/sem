package week5.pipeline;

import java.io.IOException;

import week5.adt.Document;

public class KwicTest {
	public static void main(String[] args) throws IOException {
		Filter reader  = new Reader();
		Filter shifter = new Shifter();
		Filter sorter  = new Sorter();
		Filter writer  = new Writer();
		
		reader.addSink(shifter);
		shifter.addSink(sorter);
		sorter.addSink(writer);
		
		Document doc = new Document();
		doc.read("document.txt");
		reader.putData(doc);
	}
}
