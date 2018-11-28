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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;
//import com.google.firebase.database.FirebaseDatabase;


public class NewLoadActivity extends AppCompatActivity {

    DatabaseReference loadData;
    EditText load;
    EditText origin;
    EditText destination;
    EditText price;
    Button createLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_load);

        createLoad.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {

                                          }
                                      }


        );

    }

    protected void onClick(View view){
        loadData = FirebaseDatabase.getInstance().getReference();

        load = findViewById(R.id.tvLoadName);
        origin = findViewById(R.id.tvOrigin);
        destination = findViewById(R.id.tvDestination);
        price = findViewById(R.id.tvPrice);

        String loadName = load.toString();
        String originAddress = origin.toString();
        String destAddress = destination.toString();
        int priceV = Integer.parseInt(price.toString());

        //generate new ID
        UUID id = UUID.randomUUID();

        DatabaseReference loadsRef = loadData.child("loads");

        Map<String, Load> loads = new HashMap<>();
        loads.put(loadName,  new Load(loadName, id, originAddress, destAddress, priceV));
        loadsRef.setValue(loads);
    }
}
