package com.pluralsight;

import java.io.IOException;
import java.util.Scanner;

import static com.pluralsight.HomeFunctions.*;
import static com.pluralsight.LedgerFunctions.displayAll;
import static com.pluralsight.Reader.readTransactions;

/*Welcome to the Main Class for my Accounting Ledger App
Here is where the Screens of my App will live
The Home screen will allow users to:
    D) Add deposit: Prompt user for deposit info and save to csv file
    P) Make payment: Prompt user for debit info and save to csv file
    L) Ledger - Display the Ledger Screen
    X) Exit - Exit app
The Ledger Screen will allow users to:
    Show the newest entries first
    A) All: Display all entries
    D) Deposits: Display entries that are only deposits
    P) Payments: Display only the negative entries (payments)
    R) Reports: New screen for running pre-defined reports/making custom searches
    H) Return Home
The Reports Screen will allow users to:
    1) Month to Date
    2) Previous Month
    3) Year to Date
    4) Previous Year
    5) Search by Vendor: Prompt user for vendor name and display all entries for that vendor
    0) Back: Go back to Report page
    H) Return Home
 */
public class AccountingLedgerApp {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    readTransactions();
    }

    public static void homeScreen() throws IOException {
        System.out.println("Good afternoon, Clancy. How can I assist you?");
        System.out.println(" D) Add a Deposit \n P) Make a Payment \n L) View your Ledger \n X) Exit");
        String clancysChoice = scanner.nextLine().toUpperCase().trim();
        switch(clancysChoice) {
            case "D": addDeposit();
            case "P": makePayment();
            case "L": ledgerScreen();
            case "X": System.exit(0);
            default:
                System.out.println("I'm having a hard time finding what you're looking for. Please try again, make sure your response is D, P, L, or X.");
        }
    }

    public static void ledgerScreen() {
        System.out.println("Welcome to your Ledger, which transaction history would you like to view?");
        System.out.println(" A) Display all transactions \n D) Display all deposits \n P) Display payment history \n R) Search my Reports");
        String clancysStatements = scanner.nextLine().toUpperCase().trim();
        switch(clancysStatements) {
            case "A": displayAll();
            case "D": //Display deposits only, newest first
            case "P": // Display payments only, newest first
            case "R": //View Reports Screen
        }
    }

    public static void reportsScreen() {

    }
}

