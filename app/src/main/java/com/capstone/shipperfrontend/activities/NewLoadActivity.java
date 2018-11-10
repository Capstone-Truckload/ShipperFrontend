package com.capstone.shipperfrontend.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.capstone.shipperfrontend.R;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;


public class NewLoadActivity extends AppCompatActivity {

    DatabaseReference loadData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_load);
    }

    protected void onClick(View view){
        EditText load = findViewById(R.id.tvLoadName);
        EditText origin = findViewById(R.id.tvOrigin);
        EditText destination = findViewById(R.id.tvDestination);
        EditText price = findViewById(R.id.tvPrice);

        String loadName = load.toString();
        String originAddress = origin.toString();
        String destAddress = destination.toString();
        int priceV = Integer.parseInt(price.toString());
    }
}
