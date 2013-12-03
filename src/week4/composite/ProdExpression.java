package week4.composite;

public class ProdExpression extends BinaryExpression {

	public ProdExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int result() {
		return this.left() * this.right();
	}

}
