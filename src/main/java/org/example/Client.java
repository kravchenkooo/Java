package org.example;

public class Client implements Runnable {
    private final String name;
    private final Bank bank;

    public Client(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            if (bank.isOpen()) {
                bank.useATM(this);
            } else {
                System.out.println(name + " arrived after closing and cannot use the ATM.");
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
    }

    public String getName() {
        return name;
    }
}
