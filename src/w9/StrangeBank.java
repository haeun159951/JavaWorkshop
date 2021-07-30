package w9;

public class StrangeBank {

	private static int balance; 
	private String currency;
	
	//default constructor
	public StrangeBank() {
		balance = 0;
		currency="";
	}

	//setters and getters
	public int getBalance() {
		return balance;
	}
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setBalance(int amount) {
		balance = amount; 
	}
	// method to make a deposit to account
	public synchronized void fundAccount(int amount, String currency) {
	    while(balance > 0) {  
	    	try { 
				System.out.println("Waiting for friend to withdraw...");
				wait();  
			} catch ( InterruptedException e ) { 
				e.printStackTrace();
			}
	    }
		
	    balance += amount;
	    this.currency=currency;
		System.err.println("Deposit is successfull, new balance is " + getBalance() +" "+ getCurrency());
		
		notify();  // tell a waiting thread to become ready
		}
	
	// method to withdraw from account
	public synchronized int withdrawAccount() {
		
		while(balance == 0) {   // not the friend's turn
		try { 
				System.out.println("Funds not available. Waiting for deposit...");
				wait();
			} catch (Throwable e) { 
			System.out.println(e.getMessage());
			}
		}
		
		balance -=1;
		System.err.println("Friend has withdrawed 1,bank balance is " + getBalance()+"\n");
		notify(); // tell a waiting thread to become ready
	    return 1;
	}


	
}
