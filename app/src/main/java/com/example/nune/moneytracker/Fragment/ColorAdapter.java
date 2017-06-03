package com.example.nune.moneytracker.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import static com.example.nune.moneytracker.Main.MoneyListActivity.presenter;

/**
 * Created by nune on 5/29/2017 AD.
 */

public class ColorAdapter<Money> extends ArrayAdapter {

    public ColorAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);
        if (presenter.getMoneyLists().get(presenter.getCurrentIndex()).getRecord().getMoneys().get(position).getType().equals("EXPENSE") ) {
            view.setBackgroundColor(Color.rgb(240,118,114));
        } else {
            view.setBackgroundColor(Color.rgb(247,247,247));
        }
        return view;
    }

    @Override
    public void remove(@Nullable Object object) {
        super.remove(object);
    }
}
