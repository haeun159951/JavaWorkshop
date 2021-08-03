package ws09;

enum Currency {
    Dollar, Euro, Pound
}

public class Account {
    private double balance;
    private Currency currency;


    public Account() {

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public synchronized void deposit(Currency curr, double bal) throws InterruptedException {
        while (this.currency != curr && this.balance != 0) {
            System.out.println("Balance is not empty, waiting for withdraw" + "\n");
            wait();
        }

        this.currency = curr;
        this.balance += bal;


        System.out.println("Deposited successful!: " + bal + " " + curr);
        System.out.println("Account Balance is now : " + getBalance() + " " + getCurrency() + "\n");
        notify();

    }

    public synchronized void withdraw(double bal) throws InterruptedException {
        while (this.balance == 0) {
            System.out.println("Balance is empty, Waiting for deposit" + "\n");
            wait();
        }
        this.balance -= bal;

        System.out.println("Withdraw successful!: " + bal + " " + getCurrency());
        System.out.println("Account Balance is now : " + getBalance() + " " + getCurrency() + "\n");
        notify();
    }

}
