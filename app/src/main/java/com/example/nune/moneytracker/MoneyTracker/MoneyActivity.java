package com.example.nune.moneytracker.MoneyTracker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import com.example.nune.moneytracker.Data.Record;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.R;
import java.util.ArrayList;
import java.util.Calendar;

public class MoneyActivity extends AppCompatActivity implements MoneyView {

    public static ArrayList<MoneyList> moneyLists;
    public static int currentIndex;
    private String realDate;
    Calendar dateTime = Calendar.getInstance();
    FloatingActionButton createListBtn;
    Dialog dialog;
    EditText nameTxt;
    ListView moneyListView;
    ArrayAdapter<MoneyList> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneylist_activity);

        moneyListView = (ListView) findViewById(R.id.moneyList);
        moneyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               createMoney(position);
            }
        });
        moneyLists = new ArrayList<MoneyList>();
        setMoneyList(moneyLists);
        createListBtn = (FloatingActionButton) findViewById(R.id.addMoneyListBtn);
        createListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });
    }

    @Override
    public void setMoneyList(ArrayList<MoneyList> moneyLists) {
        adapter = new ArrayAdapter<MoneyList>(this, android.R.layout.simple_list_item_1, moneyLists);
        moneyListView.setAdapter(adapter);
    }

    @Override
    public void showInputDialog() {
        dialog = new Dialog(MoneyActivity.this);
        dialog.setContentView(R.layout.moneylist_input);
        nameTxt = (EditText) dialog.findViewById(R.id.nameTxt);
        setDate();
        setMoneyLists();
    }

    public void setMoneyLists(){
        Button btn = (Button) dialog.findViewById(R.id.createBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTxt.getText().toString();
                moneyLists.add(new MoneyList(name,new Record(),realDate));
                moneyListView.setAdapter(adapter);
                setMoneyList(moneyLists);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void setDate(){
        Button dateBtn = (Button) dialog.findViewById(R.id.selectDateBtn);
        dateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });
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

    public void createMoney(int position){
        Intent intent = new Intent(MoneyActivity.this, MoneyTrackActivity.class);
        startActivity(intent);
        currentIndex = position;
    }

}






