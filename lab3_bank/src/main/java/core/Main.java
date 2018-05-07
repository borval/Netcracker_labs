package core;

public class Main {

    private static int THREADS_COUNT = 2;

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }

}
