package week4.composite;

public class MinExpression extends BinaryExpression {

	public MinExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int result() {
		return this.left() - this.right();
	}

}
