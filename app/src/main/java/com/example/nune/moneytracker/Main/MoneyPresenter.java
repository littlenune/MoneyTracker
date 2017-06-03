package com.example.nune.moneytracker.Main;

import android.app.FragmentManager;
import android.content.Intent;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Fragment.MoneyDialog;

import java.util.ArrayList;


/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public class MoneyPresenter implements MoneyView {

    public static ArrayList<MoneyList> moneyLists;
    public static int currentIndex;

    public MoneyPresenter() {
        this.moneyLists = new ArrayList<MoneyList>();
    }


    @Override
    public void addList(MoneyList m){
       moneyLists.add(m);
   }

    public ArrayList<MoneyList> getMoneyLists() {
        return moneyLists;

    }

    public  int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        MoneyPresenter.currentIndex = currentIndex;
    }
}
