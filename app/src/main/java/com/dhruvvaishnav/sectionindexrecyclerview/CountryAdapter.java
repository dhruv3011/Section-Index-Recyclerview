package com.dhruvvaishnav.sectionindexrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhruvvaishnav.sectionindexrecyclerviewlib.IndicatorScrollRecyclerView;

import java.util.ArrayList;


/**
 * Created by dhruv.vaishnav on 23-05-2016.
 */

class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> implements IndicatorScrollRecyclerView.SectionedAdapter {

    private Context ctx;
    private LayoutInflater lInflater;
    private ArrayList<CountryEntity> data;

    public CountryAdapter(Context context, ArrayList<CountryEntity> data) {
        ctx = context;
        this.data = data;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CountryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_country_item, parent, false);
        CountryHolder countryHolder = new CountryHolder(view);
        return countryHolder;
    }

    @Override
    public void onBindViewHolder(CountryHolder holder, int position) {
        holder.txt.setText(getItem(position).getCountryName() + " (" + getItem(position).getCountryCode() + ")");
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private CountryEntity getItem(int position) {
        return data.get(position);
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        return String.valueOf(getItem(position).getCountryName().charAt(0));
    }

    public class CountryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt;

        public CountryHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.tvCountryNameCode);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
