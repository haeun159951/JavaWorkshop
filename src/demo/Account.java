package demo;

/** This class creates a shared account */
public class Account {
	
	/** Fields */
	private int balance;
	private String currency;
	
	/**
	 * Two argument constructor
	 * @param balance An integer that represents account balance
	 * @param currency A string that represents account currency
	 */
	Account(int balance, String currency) {
		this.balance = balance;
		this.currency = currency;
	}
	
	/** Setters */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	/** Getters */
	public int getBalance() {
		return this.balance;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	
	/** Deposit transaction */
	public synchronized void deposit(int value, String currency) {
		while (getBalance() != 0 && getCurrency() != currency) {
			try {
				System.out.println("You cannot deposit a different currency.\n");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if (getCurrency() == currency) {
			setCurrency(currency);
			setBalance(balance += value);
		} else {
			setCurrency(currency);
			setBalance(value);
		}
		
		System.out.println("Deposited: " + value + " " + currency + ".");
		System.out.println("Balance: " + getBalance() + " " + getCurrency() + ".\n");
		notify();
	}
	
	/** Withdraw transaction */
	public synchronized void withdraw(int value) {
		while (getBalance() < value) {
			try {
				System.out.println("You cannot withdraw, insuficient balance.\n");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		setBalance(getBalance() - value);
		System.out.println("Withdraw: " + value + " " + getCurrency() + ".");
		System.out.println("Balance: " + getBalance() + " " + getCurrency() + ".\n");
		notify();
	}

}
