package week5.adt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class Document {
	private Vector<Line> lines = new Vector();

	public void add(Line line) {
		lines.addElement(line);

	}

	public Vector getLines() {
		return lines;
	}

	public void read(String filename) throws IOException {
		for(String row : Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8)) {
			if(row.isEmpty()) { continue; }
			Line line = new Line();
			for(String s : Arrays.asList(row.split(" "))) {
				line.add(new Word(s));
			}
			add(line);
		}
	}

	public void shift() {
		Enumeration elements = getLines().elements();
		int sizeDoc = getLines().size();
		for (int i = 0; i < sizeDoc; i = i + 1) {
			Line line = (Line) elements.nextElement();
			int sizeLine = line.getWords().size();
			for (int j = 0; j < sizeLine - 1; j = j + 1) {
				line = line.shift();
				add(line);
			}

		}
	}

	public void sort() {
		int n = getLines().size();
		for (int i = 0; i < n - 1; i = i + 1) {
			int m = i;
			for (int j = i + 1; j < n; j = j + 1) {
				if (((Line) getLines().elementAt(j)).before((Line) getLines()
						.elementAt(m))) {
					m = j;
				}
			}
			if (i != m) { // swap lines
				Line line = (Line) getLines().elementAt(m);
				getLines().setElementAt(getLines().elementAt(i), m);
				getLines().setElementAt(line, i);
			}
		}
	}

	@Override
	public String toString() {
		String out = new String();
		Enumeration elements = lines.elements();
		while (elements.hasMoreElements()) {
			out = out + elements.nextElement();
		}
		return out;
	}

	public void write() {
		System.out.print(this);
	}
}
