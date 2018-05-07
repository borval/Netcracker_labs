package core;

import java.util.Random;

public class Client {
    public static int id = 0;
    private Operation operation;
    private int amount;
    private int serviceTime;
    private Random random = new Random();

    public Client() {
        this.id++;
        this.operation = Operation.getRandom();
        this.amount = random.nextInt(200);
        this.serviceTime = 1000 + random.nextInt(5000-1000);
    }

    public int getId(){
        return id;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getAmount() {
        return amount;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public Random getRandom() {
        return random;
    }
}
