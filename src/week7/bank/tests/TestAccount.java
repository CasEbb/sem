package week7.bank.tests;

import week7.bank.Account;

public class TestAccount extends junit.framework.TestCase {
	Account account1;
	Account account2;

	public void setUp() {
		account1 = new Account();
		account2 = new Account();
	}

	public void tearDown() {
		// example code
		account1.withdraw(account1.getBalance());
		account2.withdraw(account2.getBalance());
	}

	public void testDeposit() {
		int amount = 10;
		account1.deposit(amount);
		assertEquals("deposit", amount, account1.getBalance());
	}

	public void testNewAccount() {
		assertNotNull("Account", account1);
		assertEquals("Balance of new account is zero.", 0,
				account1.getBalance());
		assertTrue("Balance of new account is zero.",
				0 == account1.getBalance());
		assertNotSame("Two different accounts", account1, account2);
	}

	public void testNewAccountNoSetUp() {
		// local variables are used for setting up two accounts
		Account account1 = new Account();
		assertNotNull("Account", account1);
		assertEquals("Balance of new account is zero.", 0,
				account1.getBalance());
		assertTrue("Balance of new account is zero.",
				0 == account1.getBalance());
		Account account2 = new Account();
		assertNotSame("Two different accounts", account1, account2);
	}

	public void testWithdraw() {
		int amount1 = 10;
		account1.deposit(amount1);
		assertEquals("Deposit", account1.getBalance(), amount1);
		int amount2 = 5;
		int withdrawn = account1.withdraw(amount2);
		assertEquals("Balance", amount1 - amount2 >= 0 ? amount1 - amount2 : 0,
				account1.getBalance());
		assertEquals("Withdrawn",
				amount1 - amount2 >= 0 ? amount2 : account1.getBalance(),
				withdrawn);
	}

	public void testWithdrawBalance() {
		int amount1 = 10;
		account1.deposit(amount1);
		assertEquals("Deposit", amount1, account1.getBalance());
		int withdrawn = account1.withdraw(amount1);
		assertEquals("Balance", amount1 - withdrawn, account1.getBalance());
		assertEquals("Withdrawn", amount1, withdrawn);
	}

	public void testWithdrawTooMuch() {
		int amount1 = 10;
		account1.deposit(amount1);
		assertEquals("Deposit", account1.getBalance(), amount1);
		int amount2 = 15;
		int withdrawn = account1.withdraw(amount2);
		assertEquals("Balance", account1.getBalance(),
				amount1 - amount2 >= 0 ? amount1 - amount2 : 0);
		assertEquals("Withdrawn", withdrawn, amount1 - amount2 >= 0 ? amount2
				: account1.getBalance());
	}
}
