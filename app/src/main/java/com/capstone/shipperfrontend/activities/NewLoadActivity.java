package com.capstone.shipperfrontend.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.capstone.shipperfrontend.R;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.capstone.shipperfrontend.models.Load;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


public class NewLoadActivity extends AppCompatActivity {

    private DatabaseReference loadData;
    private EditText load;
    private EditText origin;
    private EditText destination;
    private EditText price;
    private Button loadadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_load);

        loadData = FirebaseDatabase.getInstance().getReference("loads");

        load = (EditText) findViewById(R.id.tvLoadName);
        origin = (EditText) findViewById(R.id.tvOrigin);
        destination = (EditText) findViewById(R.id.tvDestination);
        price = (EditText) findViewById(R.id.tvPrice);
        loadadd = (Button) findViewById(R.id.createLoad);

        loadadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                addLoad();
            }
        });
    }

    private void addLoad(){
        Toast.makeText(this, "You pressed a button!", Toast.LENGTH_LONG).show();

        String loadName = load.getText().toString().trim();
        String originAddress = origin.getText().toString().trim();
        String destAddress = destination.getText().toString().trim();
        String priceV = price.getText().toString().trim();

        if(!TextUtils.isEmpty(loadName)){
            String id = loadData.push().getKey();

            Load load = new Load(loadName, id, originAddress, destAddress, priceV);

            loadData.child(id).setValue(load);

            Toast.makeText(this, "Load added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "You should give it a name", Toast.LENGTH_LONG).show();
        }
    }
}