package com.example.nune.moneytracker.Data;

/**
 * Created by nune on 5/30/2017 AD.
 */

public class Money {
    String description;
    double value;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Money(double expense, String description, String type){
        this.value = expense;
        this.description = description;
        this.type = type;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExpense() {

        return value;
    }

    public void setExpense(double expense) {
        this.value = expense;
    }

    public String toString(){
        return value + " "  + description + " " + type;
    }
}
