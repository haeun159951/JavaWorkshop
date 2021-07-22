package ws08;

public class Withdraw extends Thread{

    private SharedAccount account;
    private double [] balance;

    public Withdraw(SharedAccount account, double[] balance) {
        this.account = account;
        this.balance = balance;
    }

    @Override
    public void run() {
        for(int i =0; i< balance.length; i++){
            try{
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (account){
                account.withdraw(1.0);
            }
        }
    }
}
