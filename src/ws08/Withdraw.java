package ws08;

public class Withdraw extends Thread{

    private double [] balance;
    private SharedAccount account;

    public Withdraw(double[] balance, SharedAccount account) {
        this.balance = balance;
        this.account = account;
    }

    @Override
    public void run() { /// thread will do something here
        super.run();
    }
}
