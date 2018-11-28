package com.capstone.shipperfrontend.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.capstone.shipperfrontend.models.Load;
import com.capstone.shipperfrontend.R;

import java.util.List;

public class LoadsAdapter extends RecyclerView.Adapter<LoadsAdapter.LoadsViewHolder> {

    private List<Load> loadList;

    public class LoadsViewHolder extends RecyclerView.ViewHolder {
        public TextView destination, owner;

        public LoadsViewHolder(View pView) {
            super(pView);
            destination = pView.findViewById(R.id.destination);
            owner = pView.findViewById(R.id.owner);
        }
    }

    public LoadsAdapter(List<Load> pLoads) {
        loadList = pLoads;
    }

    @Override
    public LoadsViewHolder onCreateViewHolder(ViewGroup pParent, int pViewType) {
        View lItemView = LayoutInflater.from(pParent.getContext())
                        .inflate(R.layout.load_list_row, pParent, false);
        return new LoadsViewHolder(lItemView);
    }

    @Override
    public void onBindViewHolder(LoadsViewHolder pHolder, int pPosition) {
        Load lLoad = loadList.get(pPosition);
        pHolder.destination.setText(lLoad.getDestination());
        pHolder.owner.setText(lLoad.getName());
    }

    @Override
    public int getItemCount() {
        return loadList.size();
    }
}
