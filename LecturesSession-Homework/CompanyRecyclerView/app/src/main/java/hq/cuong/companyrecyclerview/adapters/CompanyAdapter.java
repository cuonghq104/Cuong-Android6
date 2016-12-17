package hq.cuong.companyrecyclerview.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hq.cuong.companyrecyclerview.R;
import hq.cuong.companyrecyclerview.models.Company;
import hq.cuong.companyrecyclerview.viewHolders.CompanyViewHolder;

/**
 * Created by Cuong on 12/13/2016.
 */
public class CompanyAdapter extends RecyclerView.Adapter<CompanyViewHolder> {


    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_company, parent, false);

        CompanyViewHolder viewHolder = new CompanyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        Company company = Company.COMPANIES[position];

        holder.bind(company);
    }

    @Override
    public int getItemCount() {
        return Company.COMPANIES.length;
    }

}
