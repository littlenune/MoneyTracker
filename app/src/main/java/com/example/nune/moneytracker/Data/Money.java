package com.example.nune.moneytracker.Data;

/**
 * Created by nune on 5/30/2017 AD.
 */

public class Money {
    String description;
    double value = 0;
    String type;
    String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Money(double value, String description, String type,String date){
        this.value = value;
        this.description = description;
        this.type = type;
        this.date = date;

    }

    public String getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString(){
        return value + "   \" "  + description + " \"   " + type + "  " + date;
    }
}
