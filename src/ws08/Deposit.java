package ws08;

public class Deposit extends Thread {
    private final Account account;
    private final Currency currency;
    private final double balance;

    public Deposit(Account account, Currency currency, double balance) {
        this.account = account;
        this.currency = currency;
        this.balance = balance;
    }

    @Override
    public void run() {
        try {
            account.deposit(currency, balance);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
