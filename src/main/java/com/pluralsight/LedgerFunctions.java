package com.pluralsight;

import java.util.Map;
import java.util.Scanner;

import static com.pluralsight.Reader.transactionList;

/*This is my LedgerFunctions class
Allows user to displayAll transactions, displayDeposits only, or displayPayments only.
 */

public class LedgerFunctions {

    public static Scanner scanner = new Scanner(System.in);
    public static void displayAll() {
        System.out.println("All Transaction History:");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            System.out.printf("Date: %S | Time: %S | Description: %S | Vendor: %S | Amount $%.2f\n", trans.getValue().getDate(), trans.getValue().getTime(), trans.getValue().getDesc(), trans.getValue().getVendor(), trans.getValue().getAmount());
        }
    }

    public static void displayDeposits() {
        System.out.println("All Deposit History:");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            if(trans.getValue().getAmount() > 0) {
                System.out.printf("Date: %S | Time: %S | Description: %S | Vendor: %S | Amount $%.2f\n", trans.getValue().getDate(), trans.getValue().getTime(), trans.getValue().getDesc(), trans.getValue().getVendor(), trans.getValue().getAmount());
            }
        }
    }

    public static void displayPayments() {
        System.out.println("All Payment History:");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            if(trans.getValue().getAmount() < 0) {
                System.out.printf("Date: %S | Time: %S | Description: %S | Vendor: %S | Amount $%.2f\n", trans.getValue().getDate(), trans.getValue().getTime(), trans.getValue().getDesc(), trans.getValue().getVendor(), trans.getValue().getAmount());
            }
        }
    }
}
