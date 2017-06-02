package com.example.nune.moneytracker.Main;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;


/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public class MoneyPresenter  {
    private MoneyView view;
    private MoneyList moneyList;

   public MoneyPresenter(MoneyView view,MoneyList moneyList){
       this.moneyList = moneyList;
       this.view = view;
   }


}
