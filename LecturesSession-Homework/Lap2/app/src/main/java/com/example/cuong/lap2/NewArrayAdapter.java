package com.example.cuong.lap2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuong on 11/20/2016.
 */
public class NewArrayAdapter extends ArrayAdapter<New> {
    public NewArrayAdapter(Context context, int resource, List<New> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_new, parent, false);
        }

        new NewViewHolder(convertView)
                .setData(getItem(position));

        return convertView;
    }
}
