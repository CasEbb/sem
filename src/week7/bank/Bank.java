package week7.bank;

import java.util.Vector;
import java.util.Enumeration;

public class Bank {
	private Vector<Account> accounts = new Vector<Account>();
	private int balance = -1;

	public void add(Account account) {
		accounts.add(account);
	}

	public int getBalance() {
		balance = 0;
		Enumeration<Account> allaccounts = accounts.elements();
		while (allaccounts.hasMoreElements()) {
			balance = balance
					+ ((Account) allaccounts.nextElement()).getBalance();
		}
		return balance;
	}
}
