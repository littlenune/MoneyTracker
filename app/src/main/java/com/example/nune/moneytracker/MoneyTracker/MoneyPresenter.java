package com.example.nune.moneytracker.MoneyTracker;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;


/**
 * Created by nune on 6/1/2017 AD.
 */

public class MoneyPresenter  {

    private MoneyView view;

    private MoneyList moneyList;

    private Money money;

   public MoneyPresenter(MoneyView view){
       this.view = view;


   }

}
