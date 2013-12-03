package week4.composite;

public class PlusExpression extends BinaryExpression {

	public PlusExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int result() {
		return this.left() + this.right();
	}

}
