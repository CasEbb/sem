package week4.composite;

public abstract class BinaryExpression implements Expression {

	private Expression left;
	private Expression right;

	public BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	abstract public int result();
	
	public int left() {
		return this.left.result();
	}
	
	public int right() {
		return this.right.result();
	}

}
