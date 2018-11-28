package com.capstone.shipperfrontend.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.capstone.shipperfrontend.R;
import com.capstone.shipperfrontend.adapters.LoadsAdapter;
import com.capstone.shipperfrontend.listeners.ClickListener;
import com.capstone.shipperfrontend.listeners.RecyclerTouchListener;
import com.capstone.shipperfrontend.models.Load;

import java.util.ArrayList;
import java.util.List;

public class LoadListActivity extends AppCompatActivity implements ClickListener {
    private RecyclerView loadsRecyclerView;
    private LoadsAdapter loadsAdapter;
    private List<Load> loadList = new ArrayList<Load>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_list);

        loadsRecyclerView = findViewById(R.id.recycler_view);
        loadsRecyclerView.setHasFixedSize(true);
        loadsAdapter = new LoadsAdapter(loadList);
        RecyclerView.LayoutManager albumLayoutManager = new LinearLayoutManager(getApplicationContext());
        loadsRecyclerView.setLayoutManager(albumLayoutManager);
        loadsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadsRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        loadsRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), loadsRecyclerView, this));
        loadsRecyclerView.setAdapter(loadsAdapter);
    }

    public void onClick(View pView, int pPosition) {
        Intent detailIntent = new Intent(this, LoadDetailsActivity.class);
        Load detailedLoad = loadList.get(pPosition);
        detailIntent.putExtra("detailedLoad", detailedLoad);

        startActivity(detailIntent);
    }

    public void onLongClick(View pView, int pPosition) {
        onClick(pView, pPosition);
    }
}
