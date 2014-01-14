package week7.bank;

public class Account {
	private int balance = 0;

	public void deposit(int amount) {
		balance = balance + amount;
	}

	public int getBalance() {
		return balance;
	}

	public int withdraw(int amount) {
		if (balance - amount < 0) {
			balance = 0;
			return balance;
		} else {
			balance = balance - amount;
			return amount;
		}
	}
}
