package com.baithiJava1;

import java.util.Scanner;

public class Account {
    private String customerCode;
    private String customerName;
    private int accNumber;
    private long amount;

    public Account() {
        this.customerCode = "";
        this.customerName = "";
        this.accNumber = 0;
        this.amount = 0L;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer code (5 characters):");
        String code = scanner.nextLine().trim();
        if (code.length() != 5) {
            System.out.println("Invalid customer code (must be 5 characters). Please try again.");
            System.out.print("Enter customer code (5 characters):");
            code = scanner.nextLine().trim();
        }
        this.customerCode = code;

        System.out.print("Enter account number (6 digits starting with 100): ");
        String account = scanner.nextLine().trim();
        boolean validAccount = false;
        while (!validAccount) {
            if (account.length() != 6 || !account.startsWith("100")) {
                System.out.println("Invalid account number (must be 6 digits starting with 100). Please try again.");
                System.out.print("Enter account number (6 digits starting with 100):");
                account = scanner.nextLine().trim();
            } else {
                validAccount = true;
            }
        }
        this.accNumber = Integer.parseInt(account);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Invalid customer name. Please try again.");
            System.out.print("Enter customer name: ");
            name = scanner.nextLine().trim();
        }
        this.customerName = name;
    }

    public void depositAndWithdraw(long money, int type) {
        if (type == 0) {
            if (money > 0) {
                this.amount += money;
                System.out.println("Amount of money " + "$" + money + " has been deposited to the account.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else if (type == 1) {
            if (money <= this.amount && money > 0) {
                this.amount -= money;
                System.out.println("$" + money + " has been withdrawn from the account.");
            } else {
                System.out.println("Non-sufficient funds or invalid withdrawal amount.");
            }
        }
    }

    @Override
    public String toString() {
        return " "+customerCode + ", " + customerName + ", " + accNumber + ", $" + amount + ".";
    }
}
