package com.example.nune.moneytracker.Main;

import com.example.nune.moneytracker.Data.MoneyList;

import java.util.ArrayList;

/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public interface MoneyView {
    void addList(MoneyList m);
    void setCurrentIndex(int index);
}
