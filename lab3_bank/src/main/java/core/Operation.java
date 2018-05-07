package core;

import java.util.Random;

public enum Operation {
    DEPOSIT,
    WITHDRAW;

    private static Operation[] values = Operation.values();
    private static int count = values.length;
    private static Random random = new Random();

    public static Operation getRandom(){
        return values[random.nextInt(count)];
    }
}
