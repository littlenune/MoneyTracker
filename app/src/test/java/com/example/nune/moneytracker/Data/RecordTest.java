package com.example.nune.moneytracker.Data;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.Record;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nune on 6/4/2017 AD.
 */

public class RecordTest {
    Record record;

    @Before
    public void setUp(){
        record = new Record();
        record.getMoneys().add( new Money(500.0,"Description","INCOME","06/02/2017"));
        assertEquals(500,record.getBalance(),0);

    }

    @Test
    public void shouldGetSize(){
        record.getMoneys().add( new Money(200.0,"Description","EXPENSE","06/02/2017"));
        record.getMoneys().add( new Money(500.0,"Description","INCOME","06/02/2017"));
        assertEquals(3,record.getMoneys().size());
    }

    @Test
    public void shouldGetBalance(){
        record.getMoneys().add( new Money(200.0,"Description","EXPENSE","06/02/2017"));
        assertEquals(300,record.getBalance(),0);
    }
}
