package com.example.nune.moneytracker.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.R;

import static com.example.nune.moneytracker.Main.MoneyListActivity.presenter;

public class BalanceActivity extends AppCompatActivity {

    TextView balanceTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        balanceTxt = (TextView) findViewById(R.id.totalBalance);
        balanceTxt.setText(String.valueOf(presenter.getTotalBalance()));

    }
}
