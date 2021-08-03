package ws8;

public class SharedAccount {
    private String currency;
    private double balance;


    public SharedAccount(String currency, double balance) {
        this.currency = currency;
        this.balance = balance;
    }

    //getters and setters
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double bal, String curr) {

        while (this.balance != 0 && !getCurrency().equals(curr)) {
            try {
                System.out.println("Currency is different to deposit\n");
                wait();
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }

        if (getCurrency() == curr) {
            setCurrency(curr);
            setBalance(this.balance += bal);
        } else {
            setCurrency(curr);
            setBalance(bal);
        }


        System.out.println("Deposited amount: " + bal + " " + curr);
        System.out.println("Account Balance is now : " + getBalance() + " " + getCurrency() + ".\n");
        notify();
    }


    public synchronized void withdraw(double bal) {
        while (this.balance < bal) {
            try {
                System.out.println("You don't have enough money to withdraw\n");
                wait();
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }

        setBalance(this.balance- bal);

        System.out.println("Withdraw amount: " + bal + " " + getCurrency());
        System.out.println("Account Balance is now : " + getBalance() + " " + getCurrency() + ".\n");
        notify();

    }

}
