package com.example.nune.moneytracker.Data;

import java.util.Date;

/**
 * Created by nune on 5/11/2017 AD.
 */

public class Money {
    String description;
    double expense;
    Date d;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Money(double expense, String description, String type, Date d){
        this.expense = expense;
        this.description = description;
        this.d = d;
        this.type = type;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public double getExpense() {

        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }
}
