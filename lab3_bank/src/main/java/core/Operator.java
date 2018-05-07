package core;

import java.util.LinkedList;
import java.util.Queue;

public class Operator extends Thread {
    public int id;
    public Queue<Client> clientsQueue;
    private CashWindow cashWindow;

    public Operator(int id) {
        this.id = id;
        clientsQueue = new LinkedList<>();
        this.cashWindow = CashWindow.getInstance();
        System.out.println("Operator " + id++ + " Начал работу");
    }

    public int getQueueLength() {
        return this.clientsQueue.size();
    }

    public int getId_() {
        return id;
    }

    public void addClient(Client client) {
        synchronized (clientsQueue) {
            clientsQueue.add(client);
            clientsQueue.notify();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                while (clientsQueue.size() < 1) {
                    synchronized (clientsQueue) {
                        System.out.println("В очереди никого нет, Оператор # " + getId_() + " Ждёт !");
                        clientsQueue.wait();
                    }
                }
                Client client = clientsQueue.poll();
                if (client.getOperation().equals(Operation.DEPOSIT)) {
                    cashWindow.deposit(client.getAmount());
                    System.out.println("Клиент # " + client.getId() + " Положил " + client.getAmount() + " $ в кассу");

                } else if (client.getAmount() <= cashWindow.getBalance()) {
                    cashWindow.withdraw(client.getAmount());
                    System.out.println("Клиент # " + client.getId() + " Взял " + client.getAmount() + " $ из кассы");
                } else {
                    System.out.println("Клиент # " + client.getId() + "хотел взять " + client.getAmount() + "  $ . В кассе недостаточно денег");
                }

                Thread.sleep(client.getServiceTime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
