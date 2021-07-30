package demo;

/** This class creates a withdraw thread */
public class Withdraw extends Thread {
	private Account sharedAccount;
	private int size;
	
	/**
	 * Two argument constructor
	 * @param sharedAccount Receives an object of type Account
	 * @param deposit Receives an integer array that was deposited
	 */
	public Withdraw(Account sharedAccount, int[] deposit) {
		this.sharedAccount = sharedAccount;
		this.size = deposit.length;
	}
	
	
	@Override
	public void run() {
		System.out.println("STARTING WITHDRAW THREAD\n");
		for (int i = 0; i < size; i++) {
			synchronized(sharedAccount) {
				sharedAccount.withdraw(1);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
}
