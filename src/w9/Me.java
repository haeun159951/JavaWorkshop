package w9;

public class Me extends Thread{
 
	
	private StrangeBank deposit;
	private int euros;
	private int dollars;
	private int pounds;
	
	public Me(StrangeBank x, int euros, int dollars, int pounds) {
		super();
		this.deposit = x;
		
		this.euros=euros;
		this.dollars= dollars;
		this.pounds=pounds;
	}
	//run method of class Thread
	public synchronized void run() {
		while(true) {
			try {
				Thread.sleep( (int) ( Math.random() * 3000 ) );
			} catch(InterruptedException e) {
				System.out.println(e.toString());
			}
			if(euros > 0) { 
			deposit.fundAccount(euros , "Euros");
			euros--;
			}
			else if(dollars > 0) { 
				deposit.fundAccount(dollars , "Dollars");
				dollars--;
				}
			else if(pounds > 0) { 
				deposit.fundAccount(pounds , "Pounds");
				pounds--;
				}
			else {
				return;
			}
		}

	}
	
}
    