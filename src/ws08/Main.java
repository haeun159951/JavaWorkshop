package ws08;

public class Main {
    public static void main(String[] args) {
        double[] balance = {1, 1, 1, 1, 1,1};
        String[] currency = {"Dollar(s)", "Pound(s)","Euro(s)",  "Pound(s)","Euro(s)", "Dollar(s)"};
        SharedAccount account = new SharedAccount("", 0.0);

        Thread deposit = new Deposit(account, balance, currency);
        Thread withdraw = new Withdraw(account, balance);

        withdraw.start();
        deposit.start();
    }
}
