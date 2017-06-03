package com.example.nune.moneytracker.Fragment;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Data.Record;
import com.example.nune.moneytracker.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public class ListDialog extends DialogFragment implements View.OnClickListener  {

    String type,des,val,date;
    double value;
    ArrayAdapter<String> categoryAdap;
    ArrayList<String> categories;
    EditText amount,description;
    Button submitBtn,dateBtn;
    Spinner categorySpinner;
    Communicator communicator;
    Calendar calendar = Calendar.getInstance();

    public interface Communicator {
        void updateAdapter(ArrayList<MoneyList> moneyLists);

        void showInputDialog();

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
        dateBtn = (Button) view.findViewById(R.id.selectDateBtn);
        categorySpinner = (Spinner) view.findViewById(R.id.spinner);
        createSpinner();
        submitBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        val = amount.getText().toString();
        des = description.getText().toString();
        if (v.getId() == R.id.submitBtn) {
            if ( val.equals("") || des.equals("") || date == null){
                Toast.makeText(getActivity(),"Please fill in all information",Toast.LENGTH_SHORT).show();
            }
            else {
                value = Double.parseDouble(val);
                communicator.onDialogMessage(new Money(value, des, type,date));
                dismiss();
            }
        }
        else if (v.getId() == R.id.selectDateBtn) {
            updateDate();
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
        categories.add("INCOME");
        categories.add("EXPENSE");
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date = month+1 + "/" + dayOfMonth  + "/" +year ;
        }

    };

    private void updateDate(){
        new DatePickerDialog(getActivity(),d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}
