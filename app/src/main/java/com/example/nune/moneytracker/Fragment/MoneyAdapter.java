package com.example.nune.moneytracker.Fragment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.nune.moneytracker.Data.MoneyList;
import com.example.nune.moneytracker.R;
import java.util.ArrayList;

import static com.example.nune.moneytracker.Main.MoneyListActivity.adapter;
import static com.example.nune.moneytracker.Main.MoneyListActivity.presenter;

/**
 * Created by nune on 6/3/2017 AD.
 */

public class MoneyAdapter extends ArrayAdapter<MoneyList> {

    public int layout;

    public MoneyAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<MoneyList> obj) {
        super(context, resource, obj);
        layout = resource;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView title;
        FloatingActionButton deleteBtn;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mainView = null;
        if ( convertView == null ){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout,parent,false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.titleTxt);
            viewHolder.title.setText(presenter.getMoneyLists().get(position).getName());
            viewHolder.deleteBtn = (FloatingActionButton) convertView.findViewById(R.id.deleteBtn);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.remove(presenter.getMoneyLists().get(position));
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(viewHolder);
        }
        else {
            mainView = (ViewHolder) convertView.getTag();
            mainView.title.setText(presenter.getMoneyLists().get(position).getName());
        }
        return convertView;
    }
}

