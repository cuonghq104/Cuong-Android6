package hq.cuong.lab4_remake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import hq.cuong.lab4_remake.models.Company;
import hq.cuong.lab4_remake.models.Item;

/**
 * Created by Cuong on 12/4/2016.
 */
public class CompanyAdapter extends ArrayAdapter<Item> {
    public CompanyAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_contact, parent, false);
        }

        new ContactViewHolder(convertView)
                .setData(getItem(position));

        return convertView;
    }
}
