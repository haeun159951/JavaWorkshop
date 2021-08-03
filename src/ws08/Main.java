package ws08;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        account.setCurrency(Currency.Pound);
        account.setBalance(0);

        List<Thread> threads = new ArrayList<>();  // 6 transactions between friend and me
        threads.add(new Deposit(account, Currency.Dollar, 1)); //friend
        threads.add(new Deposit(account, Currency.Euro, 1)); // friend
        threads.add(new Withdraw(account, 1)); //me
        threads.add(new Deposit(account, Currency.Euro, 1)); //friend
        threads.add(new Withdraw(account, 1)); // me
        threads.add(new Withdraw(account, 1)); // me

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
