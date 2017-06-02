package com.example.nune.moneytracker.MoneyTracker;

import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Fragment.ColorAdapter;
import com.example.nune.moneytracker.Fragment.ListDialog;
import com.example.nune.moneytracker.R;

import java.util.ArrayList;

import static com.example.nune.moneytracker.MoneyTracker.MoneyListActivity.currentIndex;
import static com.example.nune.moneytracker.MoneyTracker.MoneyListActivity.moneyLists;

public class ListActivity extends AppCompatActivity implements ListDialog.Communicator, MoneyView {


    public static ColorAdapter<Money> moneyArrayAdapter;
    TextView balanceTv;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneytrack_activity);
        balanceTv = (TextView) findViewById(R.id.balanceTxt);
        balanceTv.setText(String.valueOf(moneyLists.get(currentIndex).getRecord().getBalance()));
        listView = (ListView) findViewById(R.id.moneyTrackerList);
        updateAdapter(moneyLists);
        FloatingActionButton incomeBtn = (FloatingActionButton) findViewById(R.id.incomeButton);
        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });
    }

    @Override
    public void updateAdapter(ArrayList<MoneyList> moneyLists) {
        moneyArrayAdapter = new ColorAdapter<Money>(this, android.R.layout.select_dialog_item, moneyLists.get(currentIndex).getRecord().getMoneys());
        listView.setAdapter(moneyArrayAdapter);
    }

    @Override
    public void showInputDialog() {
        FragmentManager manager = getFragmentManager();
        ListDialog m = new ListDialog();
        m.show(manager, "MyDialog");
    }

    @Override
    public void onDialogMessage(Money m) {
        if ( m.getType().equals("Expense") && moneyLists.get(currentIndex).getRecord().getBalance()-m.getValue() < 0){
            Toast.makeText(this,"Wrong amount.",Toast.LENGTH_SHORT).show();
        }
        else {
            moneyLists.get(currentIndex).getRecord().getMoneys().add(m);
            updateAdapter(moneyLists);
            balanceTv.setText(String.valueOf(moneyLists.get(currentIndex).getRecord().getBalance()));
        }
    }

}

