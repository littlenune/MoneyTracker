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

import com.example.nune.moneytracker.Data.Money;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Money> moneys;
    ColorAdapter<Money> moneyArrayAdapter;
    ArrayAdapter<String> categoryAdap;
    ArrayList<String> categories;
    private static String type;
    private Dialog dialog;
    EditText amount,description;
    Spinner categorySpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories = new ArrayList<String>();
        categories.add("Income");
        categories.add("Expense");

        ListView moneyList = (ListView) findViewById(R.id.moneyTrackerList);
        moneys = new ArrayList<Money>();
        moneyArrayAdapter = new ColorAdapter<Money>(this, android.R.layout.select_dialog_item, moneys);
        moneyList.setAdapter(moneyArrayAdapter);

        FloatingActionButton incomeBtn = (FloatingActionButton) findViewById(R.id.incomeButton);
        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInput();
            }
        });
    }


    public void showInput(){
        dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Let's track your money!");
        dialog.setContentView(R.layout.input_layout);
        amount = (EditText) dialog.findViewById(R.id.valueInput);
        description = (EditText) dialog.findViewById(R.id.desInput);

        categorySpinner = (Spinner) dialog.findViewById(R.id.spinner);

        categoryAdap = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,categories);
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
                moneys.add(new Money(value,des,type));
                moneyArrayAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();

    }

}

