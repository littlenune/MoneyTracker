package com.example.nune.moneytracker;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nune.moneytracker.Data.Money;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Money> moneys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button incomeBtn = (Button) findViewById(R.id.incomeButton);

        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IncomeActivity.class);
                startActivity(i);
            }


        });
    }
    
    public void createMoney(){

    }

}
