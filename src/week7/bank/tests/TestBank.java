package week7.bank.tests;

import junit.framework.TestCase;
import week7.bank.Account;
import week7.bank.Bank;

public class TestBank extends TestCase {
	public void testBalance() {
		Bank bank = new Bank();
		Account account1 = new Account();
		bank.add(account1);
		Account account2 = new Account();
		bank.add(account2);
		int amount1 = 10;
		account1.deposit(amount1);
		int amount2 = 20;
		account2.deposit(amount2);
		assertEquals("bank balance", amount1 + amount2, bank.getBalance());
	}
}
