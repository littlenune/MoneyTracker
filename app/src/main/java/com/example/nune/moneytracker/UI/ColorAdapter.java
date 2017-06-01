package com.example.nune.moneytracker.UI;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.nune.moneytracker.Data.Money;
import com.example.nune.moneytracker.Data.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nune on 5/29/2017 AD.
 */

public class ColorAdapter<Money> extends ArrayAdapter {

    public ColorAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        if (position % 2 == 1) {
            view.setBackgroundColor(Color.rgb(240,118,114));
        } else {
            view.setBackgroundColor(Color.rgb(247,247,247));
        }

        return view;
    }


}
