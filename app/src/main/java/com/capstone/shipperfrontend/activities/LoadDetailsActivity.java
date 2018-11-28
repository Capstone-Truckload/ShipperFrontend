package com.capstone.shipperfrontend.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.capstone.shipperfrontend.R;
import com.capstone.shipperfrontend.models.Load;

public class LoadDetailsActivity extends AppCompatActivity {

    Load focus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_details);
        Intent startIntent = getIntent();
        focus = (Load) startIntent.getSerializableExtra("detailedLoad");
    }
}
