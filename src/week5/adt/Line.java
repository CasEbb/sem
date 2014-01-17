package week5.adt;

import java.util.Enumeration;
import java.util.Vector;

public class Line {
	private Vector<Word> words = new Vector();

	public void add(Word word) {
		words.addElement(word);
	}

	public boolean before(Line line) {
		if (words.size() == 0)
			return false;
		if (line.words.size() == 0)
			return true;
		if (((Word) words.elementAt(0)).equals((Word) line.words.elementAt(0))) {
			Line line1 = this.copy();
			Line line2 = line.copy();
			line1.words.removeElementAt(0);
			line2.words.removeElementAt(0);
			return line1.before(line2);
		}
		return ((Word) words.elementAt(0)).before((Word) line.words
				.elementAt(0));
	}

	public Line copy() {
		Line line = new Line();
		Enumeration elements = words.elements();
		while (elements.hasMoreElements()) {
			line.add((Word) elements.nextElement());
		}
		return line;
	}

	public Vector getWords() {
		return words;
	}

	public Line shift() {
		Line line = new Line();
		if(words.size() > 0) {
			Word word0 = (Word) words.elementAt(0);
			for (int i = 1; i < words.size(); i = i + 1) {
				Word word = (Word) words.elementAt(i);
				line.add(word);
			}
			line.add(word0);
		}
		return line;
	}

	public String toString() {
		String out = new String();
		Enumeration elements = words.elements();
		if (elements.hasMoreElements()) {
			out = ((Word) elements.nextElement()).toString();
		}
		while (elements.hasMoreElements()) {
			out = out + " " + elements.nextElement();
		}
		return out + "\n";
	}
	
	public boolean equals(Object obj) {
		if(obj.getClass() == Line.class) {
			return this.toString().equals(obj.toString());
		}
		
		return false;
	}
}
