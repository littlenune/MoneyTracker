package com.example.nune.moneytracker.Fragment;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.Data.Record;
import com.example.nune.moneytracker.R;
import java.util.Calendar;

/**
 * Created by nune on 6/moneybg/2017 AD.
 */

public class MoneyDialog extends DialogFragment implements View.OnClickListener {

    String title;
    EditText nameTxt;
    Button createBtn;
    Communicator communicator;


    public interface Communicator {
        public void onDialogMessage(MoneyList m);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moneylist_input,container);
        nameTxt = (EditText) view.findViewById(R.id.nameTxt);
        createBtn = (Button) view.findViewById(R.id.createBtn);
        createBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        title = String.valueOf(nameTxt.getText());
        if (v.getId() == R.id.createBtn) {
            if ( !title.equals("")) {
                communicator.onDialogMessage(new MoneyList(title, new Record()));
                dismiss();
            }
            else Toast.makeText(getActivity(),"Please fill in list name",Toast.LENGTH_SHORT).show();
        }

    }
}
