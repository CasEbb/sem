package week4.composite;

public class TestExpression {
	public static void main(String[] args) {
		MinExpression exp1 = new MinExpression(new Number(5), new Number(7));
		ProdExpression exp2 = new ProdExpression(exp1, new Number(8));
		PlusExpression exp3 = new PlusExpression(exp2, new Number(4));
		System.out.println(exp3.result());
	}
}
