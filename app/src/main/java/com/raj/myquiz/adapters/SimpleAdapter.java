package com.raj.myquiz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.raj.myquiz.R;

public class SimpleAdapter extends ArrayAdapter {

    Context context;
    String[] items;

    public SimpleAdapter(@NonNull Context context, String[] items) {
        super(context, R.layout.category_list_item, items);
        //super(context, resource);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false);
        TextView item = v.findViewById(R.id.tvCatItem);

        item.setText(items[position]);

        return v;
    }
}
