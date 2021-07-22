package ws8;

public class Deposit extends Thread{

    private SharedAccount account;

    private String[] currency;

    public Deposit(SharedAccount account,String[] currency) {
        this.account = account;
        this.currency = currency;
    }

    @Override
    public void run(){

        Thread activeThread = Thread.currentThread();
        System.out.println("The thread named: " + activeThread.getName() + "is ending\n");
        for(int i =0; i< 6; i++){
        synchronized (account){
            account.deposit(1, currency[i]);
                try{
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
