package ws08;

public class Deposit extends Thread{

    private SharedAccount account;
    private double[] balance;
    private String[] currency;

    public Deposit(SharedAccount account, double[] balance, String[] currency) {
        this.account = account;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public void run(){

        for(int i =0; i< balance.length; i++){
            try{
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e){
               e.printStackTrace();
            }
            synchronized (account){
                account.deposit(balance[i], currency[i]);
            }
        }
    }
}
