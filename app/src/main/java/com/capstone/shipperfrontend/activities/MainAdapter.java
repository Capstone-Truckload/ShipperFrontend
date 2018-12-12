package com.capstone.shipperfrontend.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.capstone.shipperfrontend.R;
import com.capstone.shipperfrontend.models.Load;

import java.util.ArrayList;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<Load> mLoad;

    public MainAdapter(ArrayList<Load> loads) {
        mLoad = loads;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText(mLoad.get(position).getName());
        holder.mOrigin.setText(mLoad.get(position).getOrigin());
        holder.mDestination.setText(mLoad.get(position).getDestination());
        holder.mPrice.setText(mLoad.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mLoad.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mName;
        public TextView mOrigin;
        public TextView mDestination;
        public TextView mPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.first_load);
            mOrigin = (TextView) itemView.findViewById(R.id.second_load);
            mDestination = (TextView) itemView.findViewById(R.id.third_load);
            mPrice = (TextView) itemView.findViewById(R.id.fourth_load);
        }
    }
}
