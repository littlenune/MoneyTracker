package com.example.nune.moneytracker.Data;

import static com.example.nune.moneytracker.Main.MoneyListActivity.presenter;

/**
 * Created by nune on 5/29/2017 AD.
 */

public class MoneyList {
    private String name;
    private Record record;

    public MoneyList(String name, Record record){
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public Record getRecord() {
        return record;
    }


    public String toString(){
        return getName() ;
    }


}
