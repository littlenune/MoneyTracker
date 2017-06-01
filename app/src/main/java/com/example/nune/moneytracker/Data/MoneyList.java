package com.example.nune.moneytracker.Data;

/**
 * Created by nune on 5/29/2017 AD.
 */

public class MoneyList {
    private String name;
    private Record record;
    private String calendar;

    public String getCalendar() {
        return calendar;
    }

    public MoneyList(String name, Record record, String calendar){
        this.name = name;
        this.record = record;
        this.calendar = calendar;

    }

    public String getName() {
        return name;
    }

    public Record getRecord() {
        return record;
    }


    public String toString(){
        return getName() + " : " +getCalendar();
    }
}
