package ws8;

public class Withdraw extends Thread{

    private SharedAccount account;


    public Withdraw(SharedAccount account) {
        this.account = account;

    }

    @Override
    public void run() {

        Thread activeThread = Thread.currentThread();
        System.out.println("The thread named: " + activeThread.getName()+ "is starting\n");

        for(int i =0; i< 6; i++){
            synchronized (account) {
                account.withdraw(1);
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
