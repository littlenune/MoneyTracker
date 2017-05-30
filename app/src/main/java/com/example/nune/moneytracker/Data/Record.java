package com.example.nune.moneytracker.Data;

import java.util.ArrayList;

/**
 * Created by nune on 5/30/2017 AD.
 */

public class Record {
    ArrayList<Money> moneys;
    double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Record(){
        moneys = new ArrayList<Money>();
        balance = 0;

    }

    public ArrayList<Money> getMoneys() {
        return moneys;
    }

    public void setMoneys(ArrayList<Money> moneys) {
        this.moneys = moneys;
    }
}
