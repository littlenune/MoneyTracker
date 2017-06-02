package com.example.nune.moneytracker.Data;

import java.util.ArrayList;

/**
 * Created by nune on 5/30/2017 AD.
 */

public class Record {
    ArrayList<Money> moneys;
    double balance = 0;

    public Record(){
        moneys = new ArrayList<Money>();
    }

    public double getBalance() {
        balance = 0;
        for ( Money m : moneys){
            if ( m.getType().equals("Expense") ) balance -= m.getValue();
            else balance += m.getValue();
        }

        return balance;
    }

    public ArrayList<Money> getMoneys() {
        return moneys;
    }

    public void setMoneys(ArrayList<Money> moneys) {
        this.moneys = moneys;
    }

}
