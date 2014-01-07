package week5.adt;

import java.io.IOException;

public class TestKwic {
	public static void main(String[] args) throws IOException {
		Document doc = new Document();

		doc.read("document.txt");
		System.out.println("input");
		doc.write();

		doc.shift();
		System.out.println("shifted");
		doc.write();

		doc.sort();
		System.out.println("sorted");
		doc.write();

		System.out.println("end of test");
	}
}
