package com.example.cuong.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.cuong.lab3.models.HairStyle;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Cuong on 11/27/2016.
 */
public class HairStyleArrayAdapter extends ArrayAdapter<HairStyle>{

    public HairStyleArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.getContext());

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.hair_style_item, parent, false);
        }

        new HairStyleItemHolder(convertView).setData(getItem(position), getContext());
//        return new View()
        return convertView;
    }
}
