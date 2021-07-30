package w9;

public class Main {
	private static final int EUROS=2;
	private static final int DOLLARS=1;
	private static final int POUNDS=3;
	

	
	// main method
	public static void main(String[] args) throws InterruptedException {
	
		StrangeBank account = new StrangeBank();
		
		Thread me = new Me(account, EUROS, DOLLARS, POUNDS);
		Thread friend = new Friend(account, 0);
		me.start();
		friend.start();

	 }

}
