package com.example.cuong.foodysimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.cuong.foodysimple.models.Food;

import java.util.List;

/**
 * Created by Cuong on 11/25/2016.
 */
public class FoodArrayAdapter extends ArrayAdapter<Food> {
    public FoodArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.getContext());

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_food, parent, false);
        }

        new FoodViewHolder(convertView).setData(getItem(position), getContext());

        return convertView;

    }
}
