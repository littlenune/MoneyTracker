package com.example.nune.moneytracker.Main;

import com.example.nune.moneytracker.Data.MoneyList;

import java.util.ArrayList;

/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public interface MoneyView {
    void updateAdapter(ArrayList<MoneyList> moneyLists);
    void showInputDialog();
}
