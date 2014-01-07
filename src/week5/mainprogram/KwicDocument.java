package week5.mainprogram;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KwicDocument {
	List<List<String>> data = new ArrayList<List<String>>();

	public static void main(String[] args) {
		KwicDocument doc = new KwicDocument();
		try {
			doc.read("document.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("read");
		doc.write();
		doc.shift();
		System.out.println("shift");
		doc.write();
		doc.sort();
		System.out.println("sort");
		doc.write();
		System.out.println("end of test");
	}

	public void read(String filename) throws IOException {
		for(String row : Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8)) {
			if(row.isEmpty()) { continue; }
			data.add(new ArrayList<String>(Arrays.asList(row.split(" "))));
		}
	}

	public void shift() {
		List<List<String>> newData = new ArrayList<List<String>>();
		
		for(List<String> row : data) {
			for(int i = 0; i < row.size(); i++) {
				row.add(row.remove(0));
				newData.add(new ArrayList<String>(row));
			}
		}
		
		data = newData;
	}

	public void sort() {
		Collections.sort(data, new Comparator<List<String>>() {
	        @Override public int compare(List<String> o1, List<String> o2) {
	            return o1.get(0).compareTo(o2.get(0));
	        }
	    });
	}

	public void write() {
		for(List<String> row : data) {
			for(String word : row) {
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}
}
