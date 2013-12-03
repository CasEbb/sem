package week4.composite;

public class Number implements Expression {
	private int value;

	public Number(int value) {
		this.value = value;
	}

	@Override
	public int result() {
		return value;
	}

}
