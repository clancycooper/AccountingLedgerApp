package com.pluralsight;

import java.io.IOException;
import java.util.*;

import static com.pluralsight.AccountingLedgerApp.*;
import static com.pluralsight.Reader.transactionList;

/*This is my LedgerFunctions class
In this class you'll find the following functions:
displayAll();
displayDeposits();
displayPayments();
 */

public class LedgerFunctions {

    public static Scanner scanner = new Scanner(System.in);

    public static void displayAll() throws IOException {
        ArrayList<Transaction> newestFirst = new ArrayList<>();
        System.out.println("All Transaction History:");
        System.out.println("(Recently added statements listed first)");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
           newestFirst.add(trans.getValue());
        }
        for (Transaction transaction : newestFirst) {
            System.out.println(transaction.toString());
        }
        System.out.println("Press 'X' when you're ready to return to the Ledger menu");
        String exit = scanner.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Ledger menu...");
            ledgerScreen();
        } else {
        System.out.println("Sorry, didn't catch that. Press 'X' to return to the Ledger Menu");
        displayAll();
    }
    }

    public static void displayDeposits() throws IOException {
        ArrayList<Transaction> newestFirst = new ArrayList<>();
        System.out.println("All Deposit History:");
        System.out.println("(Recently added statements listed first)");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            if (trans.getValue().getAmount() > 0) {
                newestFirst.add(trans.getValue());
            }
        }
        for (Transaction transaction : newestFirst) {
            System.out.println(transaction.toString());
        }
        System.out.println("Press 'X' when you're ready to return to the Ledger menu");
        String exit = scanner.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Ledger menu...");
            ledgerScreen();
        } else {
            System.out.println("Sorry, didn't catch that. Press 'X' to return to the Ledger Menu");
            displayDeposits();
        }
    }

    public static void displayPayments() throws IOException {
        ArrayList<Transaction> newestFirst = new ArrayList<>();
        System.out.println("All Payment History:");
        System.out.println("(Recently added statements listed first)");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            if (trans.getValue().getAmount() < 0) {
                newestFirst.add(trans.getValue());
            }
        }
        for (Transaction transaction : newestFirst) {
            System.out.println(transaction.toString());
        }
        System.out.println("Press 'X' when you're ready to return to the Ledger menu");
        String exit = scanner.nextLine().toUpperCase().trim();
        if (exit.equals("X")) {
            System.out.println("Redirecting to Ledger menu...");
            ledgerScreen();
        } else {
            System.out.println("Sorry, didn't catch that. Press 'X' to return to the Ledger Menu");
            displayPayments();
        }
    }
}
