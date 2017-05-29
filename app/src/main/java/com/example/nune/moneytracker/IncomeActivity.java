package com.example.nune.moneytracker;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.nune.moneytracker.Data.Money;

//import static com.example.nune.moneytracker.MainActivity.moneys;

public class IncomeActivity extends AppCompatActivity {

    EditText money,des;
    FloatingActionButton addMoney;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        money = (EditText) findViewById(R.id.money);
        des = (EditText) findViewById(R.id.description);

        addMoney = (FloatingActionButton) findViewById(R.id.addIncomeBtn);
        addMoney.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                double value = (Double.parseDouble(money.getText().toString()));
                String description = des.getText().toString();
//                moneys.add(new Money(value,description,"income"));

//                Log.d("None",moneys.toString());
            }
        });

    }


}
