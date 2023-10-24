package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*This is my HomeFunctions class, where my methods for my homeScreen will exist
addDeposits method - Allows user to enter new deposit into transactions.csv
 */

public class HomeFunctions {
    public static Scanner scanner = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static DateTimeFormatter hms = DateTimeFormatter.ofPattern("HH:mm:ss");


    public static void addDeposit() throws IOException {
        System.out.println("In order to add a new Deposit to your transaction history, we will need a little information from you.");
        System.out.println("Please provide a description \n Example: Paycheck");
        String desc = scanner.nextLine();
        System.out.println("Got it, and what vendor provided this Deposit? \n Example: The UPS Store");
        String vendor = scanner.nextLine();
        System.out.print("Finally, what amount is this deposit for? \n Example: 100.00 \n$");
        float amount = scanner.nextFloat();
        String amountDF = df.format(amount);

        String date = String.valueOf(LocalDate.now());
        String time = hms.format(LocalTime.now());

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));
        fileWriter.write(date + "|" + time + "|" + desc + "|" + vendor + "|" + amountDF);
        fileWriter.newLine();
        fileWriter.close();
    }
}
