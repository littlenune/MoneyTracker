package com.example.nune.moneytracker;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.Record;
import com.example.nune.moneytracker.Data.MoneyList;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    public static ArrayList<MoneyList> moneyLists;
    Calendar dateTime = Calendar.getInstance();

    FloatingActionButton createListBtn;
    Dialog dialog;
    EditText nameTxt;
    ListView lists;
    ArrayAdapter<MoneyList> adapter;
    private String realDate;
    public static int currentIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lists = (ListView) findViewById(R.id.moneyList);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, MoneyTrackActivity.class);
                startActivity(intent);
                currentIndex = position;
                Log.d("POSITION",String.valueOf(currentIndex));

            }
        });

        moneyLists = new ArrayList<MoneyList>();


        createListBtn = (FloatingActionButton) findViewById(R.id.addMoneyListBtn);

        createListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInput();
            }
        });

        updateAdapter();

    }


    public void updateAdapter(){
        adapter = new ArrayAdapter<MoneyList>(this, android.R.layout.simple_list_item_1, moneyLists);
        lists.setAdapter(adapter);

    }


    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            realDate = month+1 + "/" + dayOfMonth  + "/" +year ;
        }
    };

    private void updateDate(){
        new DatePickerDialog(this,d,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void showInput(){
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_money);
        nameTxt = (EditText) dialog.findViewById(R.id.nameTxt);

        Button btn = (Button) dialog.findViewById(R.id.createBtn);
        Button dateBtn = (Button) dialog.findViewById(R.id.selectDateBtn);

        dateBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                updateDate();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = nameTxt.getText().toString();
                moneyLists.add(new MoneyList(name,new Record(),realDate));
                updateAdapter();

                dialog.dismiss();
            }
        });
        dialog.show();

    }

}






