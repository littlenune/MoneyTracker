package com.example.nune.moneytracker.MoneyTracker;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Fragment.MoneyDialog;
import com.example.nune.moneytracker.R;

import java.util.ArrayList;

public class MoneyListActivity extends AppCompatActivity implements MoneyDialog.Communicator, MoneyView{

    public static ArrayList<MoneyList> moneyLists;
    public static int currentIndex;
    public FloatingActionButton createListBtn;
    public ListView moneyListView;
    public static ArrayAdapter<MoneyList> adapter;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
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

        createListBtn = (FloatingActionButton) findViewById(R.id.addMoneyListBtn);
        createListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();

            }
        });
    }

    @Override
    public void updateAdapter(ArrayList<MoneyList> moneyLists) {
        adapter = new ArrayAdapter<MoneyList>(this, android.R.layout.simple_list_item_1, moneyLists);
        moneyListView.setAdapter(adapter);
    }

    @Override
    public void showInputDialog() {
        FragmentManager manager = getFragmentManager();
        MoneyDialog m = new MoneyDialog();
        m.show(manager,"MyDialog");
    }

    @Override
    public void onDialogMessage(MoneyList m) {
        moneyLists.add(m);
        updateAdapter(moneyLists);
    }

    public void createMoney(int position){
        Intent intent = new Intent(MoneyListActivity.this, ListActivity.class);
        startActivity(intent);
        currentIndex = position;
    }
}


