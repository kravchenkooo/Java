package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int ATM_COUNT = 3;
        Bank bank = new Bank(ATM_COUNT);

        Thread[] clients = new Thread[10];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Thread(new Client("Client " + (i + 1), bank));
            clients[i].start();
            Thread.sleep(500);
        }

        Thread.sleep(7000);
        bank.closeBank();

        for (Thread client : clients) {
            client.join();
        }

        System.out.println("All clients have finished.");
    }
}

