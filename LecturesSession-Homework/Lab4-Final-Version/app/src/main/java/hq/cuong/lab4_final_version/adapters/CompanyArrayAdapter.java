package hq.cuong.lab4_final_version.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.zip.Inflater;

import hq.cuong.lab4_final_version.CompanyItemHolder;
import hq.cuong.lab4_final_version.R;
import hq.cuong.lab4_final_version.models.Item;

/**
 * Created by Cuong on 12/5/2016.
 */
public class CompanyArrayAdapter extends ArrayAdapter<Item> {
    public CompanyArrayAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.getContext());

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.company_list_item, parent, false);
        }

        new CompanyItemHolder(convertView).setData(getContext(), getItem(position));

        return convertView;
    }
}
