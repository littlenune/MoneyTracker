package com.example.nune.moneytracker.Fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.R;

import java.util.ArrayList;

/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public class ListDialog extends DialogFragment implements View.OnClickListener  {

    String type,des;
    double value;
    ArrayAdapter<String> categoryAdap;
    ArrayList<String> categories;
    EditText amount,description;
    Button submitBtn;
    Spinner categorySpinner;
    Communicator communicator;


    public interface Communicator {
        public void onDialogMessage(Money m);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.money_input,container);
        amount = (EditText) view.findViewById(R.id.valueInput);
        description = (EditText) view.findViewById(R.id.desInput);
        submitBtn = (Button) view.findViewById(R.id.submitBtn);
        categorySpinner = (Spinner) view.findViewById(R.id.spinner);
        createSpinner();
        submitBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        value = Double.parseDouble(amount.getText().toString());
        des = description.getText().toString();
        if (v.getId() == R.id.submitBtn) {
            communicator.onDialogMessage(new Money(value,des,type));
            dismiss();
        }
    }

    public void createSpinner(){
        setCategorySpinner();
        categoryAdap = new ArrayAdapter<String>(getActivity(),android.R.layout.select_dialog_item,categories);
        categorySpinner.setAdapter(categoryAdap);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = categories.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setCategorySpinner(){
        categories = new ArrayList<String>();
        categories.add("Income");
        categories.add("Expense");
    }


}
