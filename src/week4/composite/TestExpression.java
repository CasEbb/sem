package week4.composite;

public class TestExpression {

	private static TestExpression instance;

	private TestExpression() {
	}

	public static TestExpression getInstance() {
		if (instance == null) {
			instance = new TestExpression();
		}

		return instance;
	}

	public int getTestResult() {
		MinExpression exp1 = new MinExpression(new Number(5), new Number(7));
		ProdExpression exp2 = new ProdExpression(exp1, new Number(8));
		PlusExpression exp3 = new PlusExpression(exp2, new Number(4));
		return exp3.result();
	}

	public static void main(String[] args) {
		TestExpression test = TestExpression.getInstance();
		System.out.println(test.getTestResult());
	}

}
