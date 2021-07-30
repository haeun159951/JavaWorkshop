package w9;

public class Friend extends Thread{
	 
	  private StrangeBank withdraw;
	  private int amount;
	 
	  public Friend(StrangeBank x, int amount) {
		super();
		withdraw = x;
		this.amount = amount;
		
	}
	//run method of class Thread
	public void run() {
		int val;
		do {
			// sleep for a random interval
			try {
				Thread.sleep( (int) ( Math.random() * 3000 ) );
			} catch(InterruptedException e) {
				System.out.println(e.toString());
			}
			val = withdraw.withdrawAccount();
		} while (val != amount);
	
	}
		
	}
