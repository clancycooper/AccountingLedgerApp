package com.pluralsight;
import java.sql.Time;
import java.util.Date;

/*This is the Transaction class
Serves as a way to get and set date|time|description|vendor|amount
 */
public class Transaction {

    private Date date;
    private Time time;
    private String desc = "";
    private String vendor = "";
    private float amount = 0.00F;

    public Transaction(Date date, Time time, String desc, String vendor, float amount) {
        this.date = new Date(date.getTime());
        this.time = new Time(time.getTime());
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

}