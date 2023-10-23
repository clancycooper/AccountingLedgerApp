package com.pluralsight;

import java.io.*;
import java.util.*;

import static com.pluralsight.AccountingLedgerApp.homeScreen;

/*This is the ReadWrite Class
Here is where my buffered/file readers and writers are stored
When launched, my main method will start the readTransactions method automatically
 */
public class ReadWrite {
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
                String date = inventory[0];
                String time = inventory[1];
                String desc = inventory[2];
                String vendor = inventory[3];
                float amount = Float.parseFloat(inventory[4]);
                Transaction newTransaction = new Transaction(date, time, desc, vendor, amount);
                transactionList.put(date, newTransaction);
            }
            homeScreen();
            fileReader.close();
            bufReader.close();
        } catch (IOException e) {
            System.out.println("Sorry, there was an IOException!");
            e.printStackTrace();
        }
    }

    public static void writeTransactions() {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
            for(Map.Entry<String, Transaction> trans : transactionList.entrySet()) {
            fileWriter.write(trans.getValue().getDate() + trans.getValue().getTime() + trans.getValue().getDesc() + trans.getValue().getVendor() + trans.getValue().getAmount());
            fileWriter.newLine();
            fileWriter.close();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
