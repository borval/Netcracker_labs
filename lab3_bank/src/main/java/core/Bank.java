package core;

import java.util.ArrayList;
import java.util.List;


public class Bank {
    private List<Operator> operators;
    private final int OPERATORS_COUNT = 2;

    public Bank() {
        operators = new ArrayList<Operator>(OPERATORS_COUNT);

        for (int i = 0; i < OPERATORS_COUNT; i++) {
            Operator operator = new Operator(i);
            operators.add(operator);
            new Thread(operator).start();
        }
    }

    public Operator getShortestQueue() {
        int minCount = operators.get(0).getQueueLength();
        Operator oper = operators.get(0);
        for (Operator operator : operators) {
            if (operator.getQueueLength() < minCount) {
                minCount = operator.getQueueLength();
                oper = operator;
            }
        }
        return oper;
    }


    public void start() {
        try {
            while (true) {
                Client client = new Client();
                Operator operator = getShortestQueue();
                operator.addClient(client);
                System.out.println("Client # " + client.getId() + " Встал в очередь к оператору # " + operator.getId_() + "; Длина очереди = " + operator.getQueueLength());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {

    }
}
