package week5.adt;

public class Word {
	private String value = new String();

	public Word(String s) {
		value = s;
	}

	public boolean before(Word w) {
		return value.compareTo(w.value) < 0;
	}

	public boolean equals(Word w) {
		return value.compareTo(w.value) == 0;
	}

	public String toString() {
		return value;
	}
}
