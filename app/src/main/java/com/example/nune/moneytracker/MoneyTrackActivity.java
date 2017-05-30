package com.example.nune.moneytracker;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nune.moneytracker.Data.Money;

import java.util.ArrayList;

import static com.example.nune.moneytracker.MainActivity.currentIndex;
import static com.example.nune.moneytracker.MainActivity.moneyLists;

public class MoneyTrackActivity extends AppCompatActivity {

    ColorAdapter<Money> moneyArrayAdapter;
    ArrayAdapter<String> categoryAdap;
    ArrayList<String> categories;
    private static String type;
    private Dialog dialog;
    EditText amount,description;
    Spinner categorySpinner;
    double balance = 0;
    TextView balanceTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_track);

        categories = new ArrayList<String>();
        categories.add("Income");
        categories.add("Expense");

        balanceTv = (TextView) findViewById(R.id.balanceTxt);

        balanceTv.setText(String.valueOf(moneyLists.get(currentIndex).getRecord().getBalance()));

        ListView listView = (ListView) findViewById(R.id.moneyTrackerList);

        moneyArrayAdapter = new ColorAdapter<Money>(this, android.R.layout.select_dialog_item, moneyLists.get(currentIndex).getRecord().getMoneys());
        listView.setAdapter(moneyArrayAdapter);


        FloatingActionButton incomeBtn = (FloatingActionButton) findViewById(R.id.incomeButton);
        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInput();
            }
        });
    }

    public void showInput(){

        dialog = new Dialog(MoneyTrackActivity.this);
        dialog.setTitle("Let's track your money!");
        dialog.setContentView(R.layout.input_layout);
        amount = (EditText) dialog.findViewById(R.id.valueInput);
        description = (EditText) dialog.findViewById(R.id.desInput);
        categorySpinner = (Spinner) dialog.findViewById(R.id.spinner);
        categoryAdap = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,categories);
        categorySpinner.setAdapter(categoryAdap);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = categories.get(position);
                Log.d("None",type);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        Button btn = (Button) dialog.findViewById(R.id.submitBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = (Double.parseDouble(amount.getText().toString()));
                String des = description.getText().toString();
                if ( type.equals("Expense") && balance - value < 0){
                    Toast.makeText(getApplicationContext(),"Wrong amount or type",Toast.LENGTH_SHORT).show();
                }
                else {
                    moneyLists.get(currentIndex).getRecord().getMoneys().add(new Money(value, des, type));
                    if ( type.equals("Income")){
                        balance += value;
                    }
                    else balance -= value;
                    moneyLists.get(currentIndex).getRecord().setBalance(balance);
                    balanceTv.setText("BALANCE:" + moneyLists.get(currentIndex).getRecord().getBalance());
                    moneyArrayAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
