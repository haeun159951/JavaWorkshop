package ws08;

public class Withdraw extends Thread {
    private Account account;
    private double balance;

    public Withdraw(Account account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    @Override
    public void run() {
        try {
            this.account.withdraw(balance);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
