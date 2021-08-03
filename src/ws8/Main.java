/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 9
/*  Date: Aug 3, 2021
/* ********************************************************************/

package ws8;

public class Main {
    public static void main(String[] args) {
        //initialize the balance and currency
        String[] currency = {"Dollar(s)", "Pound(s)", "Pound(s)", "Euro(s)", "Pound(s)", "Euro(s)"};
        SharedAccount account = new SharedAccount("", 0.0);

        // two threads for deposit and withdraw and start it
        Thread withdraw = new Withdraw(account);
        Thread deposit = new Deposit(account, currency);


        withdraw.start();
        deposit.start();


    }
}
