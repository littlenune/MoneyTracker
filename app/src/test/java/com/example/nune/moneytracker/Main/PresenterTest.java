package com.example.nune.moneytracker.Main;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Data.Record;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nune on 6/4/2017 AD.
 */

public class PresenterTest {
    MoneyPresenter presenter;

    @Before
    public void setUp(){
        presenter = new MoneyPresenter();
        presenter.addList(new MoneyList("FirstList",new Record()));
        presenter.addList(new MoneyList("SecondList",new Record()));
        presenter.addList(new MoneyList("ThirdList",new Record()));
        presenter.getMoneyLists().get(0).getRecord().getMoneys().add(new Money(200,"Income","INCOME","06/02/2017"));
        presenter.getMoneyLists().get(0).getRecord().getMoneys().add(new Money(200,"Income","INCOME","06/02/2017"));
        presenter.getMoneyLists().get(0).getRecord().getMoneys().add(new Money(100,"Expense","EXPENSE","06/02/2017"));
        presenter.getMoneyLists().get(1).getRecord().getMoneys().add(new Money(500,"Income","INCOME","06/02/2017"));
        presenter.getMoneyLists().get(1).getRecord().getMoneys().add(new Money(100,"EXpense","EXPENSE","06/02/2017"));

    }

    @Test
    public void shouldGetAddedList(){
        assertEquals("SecondList",presenter.getMoneyLists().get(1).getName());
        assertEquals("ThirdList",presenter.getMoneyLists().get(2).getName());
    }

    @Test
    public void shouldGetSelectedBalance(){
        assertEquals(300,presenter.getMoneyLists().get(0).getRecord().getBalance(),0);
        assertEquals(400,presenter.getMoneyLists().get(1).getRecord().getBalance(),0);
    }

    @Test
    public void shouldGetTotalBalance(){
        assertEquals(700,presenter.getTotalBalance(),0);
    }
}
