package com.example.nune.moneytracker.Data;

import android.util.Log;

import com.example.nune.moneytracker.Data.Money;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by nune on 6/4/2017 AD.
 */

public class MoneyTest {
    Money m;

    @Before
    public void setUp(){
        m = new Money(200.0,"Income","INCOME","06/02/2017");

    }

    @Test
    public void shouldGetAmount(){
        assertEquals(200.0,m.getValue(),0);
    }

    @Test
    public void shouldGetDescription(){
        assertEquals("Income",m.getDescription());
    }

    @Test
    public void shouldGetType(){
        assertEquals("INCOME",m.getType());
    }

    @Test
    public void shouldGetDate(){
        assertEquals("06/02/2017",m.getDate());
    }
}
