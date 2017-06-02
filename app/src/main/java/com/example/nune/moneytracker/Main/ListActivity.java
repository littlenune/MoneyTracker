package com.example.nune.moneytracker.Main;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Fragment.ColorAdapter;
import com.example.nune.moneytracker.Fragment.ListDialog;
import com.example.nune.moneytracker.R;

import java.util.ArrayList;

import static com.example.nune.moneytracker.Main.MoneyListActivity.currentIndex;
import static com.example.nune.moneytracker.Main.MoneyListActivity.moneyLists;

public class ListActivity extends AppCompatActivity implements ListDialog.Communicator, MoneyView {


    public static ColorAdapter<Money> moneyArrayAdapter;
    TextView balanceTxt;
    ListView listView;
    double balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneytrack_activity);
        balanceTxt = (TextView) findViewById(R.id.balanceTxt);
        balanceTxt.setText(String.valueOf(moneyLists.get(currentIndex).getRecord().getBalance()));
        listView = (ListView) findViewById(R.id.moneyTrackerList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(ListActivity.this);
                alert.setMessage("Do you want to delete this from track list");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        moneyArrayAdapter.remove(moneyArrayAdapter.getItem(position));
                        Toast.makeText(getApplicationContext(), "Removed from list", Toast.LENGTH_SHORT).show();
                        updateBalance();

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
            }
        });

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
            updateBalance();
        }
    }

    public void updateBalance(){
        balance = moneyLists.get(currentIndex).getRecord().getBalance();
        balanceTxt.setText(String.valueOf(balance));
    }

}

