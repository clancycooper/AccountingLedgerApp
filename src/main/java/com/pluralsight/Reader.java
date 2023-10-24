package com.pluralsight;

import java.io.*;
import java.util.*;

import static com.pluralsight.AccountingLedgerApp.homeScreen;

/*This is the Reader Class
Here is where my buffered/file readers are stored
When launched, my main method will start the readTransactions method automatically
 */
public class Reader {
    public static HashMap<String, Transaction> transactionList = new HashMap<>();
    public static void readTransactions() {
        try {
            //Declaring readers/String
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String csv;
            //While loop for reading and adding products to Hashmap
            while ((csv = bufReader.readLine()) != null) {
                String[] inventory = csv.split("\\|");
                if(!inventory[0].contains("date")) {
                    String date = inventory[0];
                    String time = inventory[1];
                    String desc = inventory[2];
                    String vendor = inventory[3];
                    float amount = Float.parseFloat(inventory[4]);
                    Transaction newTransaction = new Transaction(date, time, desc, vendor, amount);
                    transactionList.put(date + time, newTransaction);
                }
            }
            homeScreen();
            fileReader.close();
            bufReader.close();
        } catch (IOException e) {
            System.out.println("Sorry, there was an IOException!");
            e.printStackTrace();
        }
    }
}
