package demo;

/** This class creates a deposit thread */
public class Deposit extends Thread {
	private Account sharedAccount;
	private int[] balance;
	private String[] currency;
	
	/**
	 * Three argument constructor
	 * @param sharedAccount Receives an object of type Account
	 * @param balance Receives an integer array with the values that will be deposited
	 * @param currency Receives a string array with the currency that will be deposited
	 */
	public Deposit(Account sharedAccount, int[] balance, String[] currency) {
		this.sharedAccount = sharedAccount;
		this.balance = balance;
		this.currency = currency;
	}
	
	
	@Override
	public void run() {
		int i = 0;
		System.out.println("STARTING DEPOSIT THREAD\n");
		while (i >= 0 && i < balance.length) {
			synchronized(sharedAccount) {
				sharedAccount.deposit(balance[i], currency[i]);
				
				try {
					if (i < balance.length && i >= 0) i++;
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
