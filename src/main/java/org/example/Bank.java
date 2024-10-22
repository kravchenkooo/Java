package org.example;

import java.util.concurrent.Semaphore;

public class Bank {
    private final Semaphore atms;
    private boolean isOpen;

    public Bank(int atmCount) {
        this.atms = new Semaphore(atmCount, true);
        this.isOpen = true;
    }

    public void useATM(Client client) throws InterruptedException {
        if (!isOpen) {
            System.out.println("Bank is closed, " + client.getName() + " cannot access ATM.");
            return;
        }
        System.out.println(client.getName() + " is waiting to use an ATM.");
        atms.acquire();
        System.out.println(client.getName() + " is using an ATM.");
        Thread.sleep(2000);
        System.out.println(client.getName() + " has finished using the ATM.");
        atms.release();
    }

    public void closeBank() {
        this.isOpen = false;
        System.out.println("The bank is now closed. ATMs are no longer available.");
    }

    public boolean isOpen() {
        return isOpen;
    }
}
