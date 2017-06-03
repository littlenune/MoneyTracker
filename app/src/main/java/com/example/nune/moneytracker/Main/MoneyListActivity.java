package com.example.nune.moneytracker.Main;

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

public class MoneyListActivity extends AppCompatActivity implements MoneyDialog.Communicator  {

    public static MoneyPresenter presenter;

    public FloatingActionButton createListBtn;
    public ListView moneyListView;
    public ArrayAdapter<MoneyList> arrayAdapter;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneylist_activity);

        presenter = new MoneyPresenter();
        init();
    }

    private void init(){

        moneyListView = (ListView) findViewById(R.id.moneyList);
        moneyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MoneyListActivity.this, ListActivity.class);
                presenter.setCurrentIndex(position);
                startActivity(intent);

            }

        });

        createListBtn = (FloatingActionButton) findViewById(R.id.addMoneyListBtn);
        createListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();

            }
        });
    }

    private void updateAdapter(ArrayList<MoneyList> moneyLists) {
        arrayAdapter =  new ArrayAdapter<MoneyList>(this, android.R.layout.select_dialog_item, presenter.getMoneyLists());
        moneyListView.setAdapter(arrayAdapter);
    }

    private void showInputDialog() {
        FragmentManager manager = getFragmentManager();
        MoneyDialog m = new MoneyDialog();
        m.show(manager,"MyDialog");
    }

    @Override
    public void onDialogMessage(MoneyList m) {
        presenter.addList(m);
        updateAdapter(presenter.getMoneyLists());
    }
}


