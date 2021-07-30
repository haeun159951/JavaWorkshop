package demo;


public class Main {

	/**
	 * Main
	 * Creates two threads that share the same account
	 * On thread tries to withdraw while the other thread makes the deposits
	 */
	public static void main(String[] args) {
		
		int[] balance = {1, 1, 1, 1, 1, 1};
		String[] currency = {"Dollar(s)", "Euro(s)", "Euro(s)", "Pound(s)", "Pound(s)", "Pound(s)"};
		Account sharedAccount = new Account(0, "");
		
		Thread withdraw = new Withdraw(sharedAccount, balance);
		Thread deposit = new Deposit(sharedAccount, balance, currency);
		
		withdraw.start();
		deposit.start();
		
		try {
			withdraw.join();
			deposit.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
