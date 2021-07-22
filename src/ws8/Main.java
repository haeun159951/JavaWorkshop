package ws8;

public class Main {
    public static void main(String[] args) {
        //initialize the balance and currency

        String[] currency = {"Dollar(s)", "Pound(s)","Euro(s)", "Euro(s)", "Dollar(s)", "Pound(s)"};
        SharedAccount account = new SharedAccount("", 0.0);

        // two threads for deposit and withdraw and start it
        Thread deposit = new Deposit(account, currency);
        Thread withdraw = new Withdraw(account);

        withdraw.start();
        deposit.start();
    }
}
