package core;

import java.util.Queue;

public class CashWindow {



    private static CashWindow instance;
    private int balance = 300;

    public static CashWindow getInstance(){
        if(instance == null){
            instance = new CashWindow();
        }
        return instance;
    }

    synchronized int getBalance() {
        return balance;
    }

    synchronized public void deposit(int amount) {
        balance += amount;
        System.out.println("Остаток " + balance);
    }

    synchronized public void withdraw(int amount) {
        balance -= amount;
        System.out.println("Остаток " + balance);
    }
}
