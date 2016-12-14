package hq.cuong.lab5.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.zip.Inflater;

import hq.cuong.lab5.R;
import hq.cuong.lab5.networks.jsonmodels.HomeContent;
import hq.cuong.lab5.viewholders.MenuViewHolder;

/**
 * Created by Cuong on 12/14/2016.
 */
public class MenuAdapter extends ArrayAdapter<HomeContent> {

    private static final String TAG = MenuAdapter.class.toString();

    public MenuAdapter(Context context, int resource, List<HomeContent> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.getContext());

        if (convertView == null)
            convertView = inflater.inflate(R.layout.menu_item, parent, false);

        new MenuViewHolder(convertView)
                .setData(getItem(position), getContext());


        return convertView;
    }
}
