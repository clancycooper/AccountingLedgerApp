package com.pluralsight;

import java.text.DecimalFormat;

/*This is the Transaction class
Serves as a way to get and set date|time|description|vendor|amount
 */
public class Transaction {

    private String date;
    private String time;
    private String desc;
    private String vendor;
    private float amount;

    public Transaction(String date, String time, String desc, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String amountDF = df.format(amount);
        return
                " Date: " + date + " | " +
                "Time: " + time + " | " +
                "Description: " + desc + " | " +
                "Vendor: " + vendor + " | " +
                "Amount: $" + amountDF;
    }
}