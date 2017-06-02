package com.example.nune.moneytracker.UI;

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
 * Created by nune on 6/1/2017 AD.
 */

public class MoneyDialog extends DialogFragment implements View.OnClickListener {

    String date,title = null;
    Calendar calendar = Calendar.getInstance();
    EditText nameTxt;
    Button dateBtn,createBtn;
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
        dateBtn = (Button) view.findViewById(R.id.selectDateBtn);
        createBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        title = String.valueOf(nameTxt.getText());
        if (v.getId() == R.id.createBtn) {
            if ( date != null ) {
                communicator.onDialogMessage(new MoneyList(title, new Record(), date));
                dismiss();
            }
            else Toast.makeText(getActivity(),"Select date or fill in title",Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.selectDateBtn) {
                updateDate();
        }
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date = month+1 + "/" + dayOfMonth  + "/" +year ;
        }

    };

    private void updateDate(){
        new DatePickerDialog(getContext(),d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

}
