package com.capstone.shipperfrontend.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.capstone.shipperfrontend.R;

public class HubActivity extends AppCompatActivity {

    private Button CreateLoad;
    private Button ViewLoad;
    private Button Account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        CreateLoad = (Button) findViewById(R.id.newLoadButton);
        ViewLoad = (Button) findViewById(R.id.currentButton);
        Account = (Button) findViewById(R.id.accountButton);

        CreateLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HubActivity.this, NewLoadActivity.class));
            }
        });

        ViewLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HubActivity.this, CurrentLoadsActivity.class));
            }
        });

        Account.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HubActivity.this, ManageAccountActivity.class));
            }
        });
    }
}
