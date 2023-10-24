package com.pluralsight;

import java.util.Map;
import java.util.Scanner;

import static com.pluralsight.Reader.transactionList;

public class LedgerFunctions {

    public static Scanner scanner = new Scanner(System.in);
    public static void displayAll() {
        System.out.println("All Transaction History:");
        for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            System.out.printf("Date: %S | Time: %S | Description: %S | Vendor: %S | Amount $%.2f\n", trans.getValue().getDate(), trans.getValue().getTime(), trans.getValue().getDesc(), trans.getValue().getVendor(), trans.getValue().getAmount());
        }
    }
}
