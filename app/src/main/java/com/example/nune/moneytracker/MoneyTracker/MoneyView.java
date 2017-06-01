package com.example.nune.moneytracker.MoneyTracker;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;

import java.util.ArrayList;

/**
 * Created by nune on 6/1/2017 AD.
 */

public interface MoneyView {
    void setMoneyList(ArrayList<MoneyList> moneyLists);
    void showInputDialog();
}
