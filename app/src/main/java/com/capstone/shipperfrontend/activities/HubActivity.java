package com.capstone.shipperfrontend.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.capstone.shipperfrontend.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HubActivity extends AppCompatActivity {

    private Button CreateLoad;
    private Button ViewLoad;
    private Button Account;
    private Button LogOut;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        CreateLoad = (Button) findViewById(R.id.newLoadButton);
        ViewLoad = (Button) findViewById(R.id.currentButton);
        Account = (Button) findViewById(R.id.accountButton);
        LogOut = (Button) findViewById(R.id.logoutButton);

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

        LogOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                firebaseAuth.getInstance().signOut();

                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                if(user == null){
                    Toast.makeText(HubActivity.this, "Logout Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HubActivity.this, LoginActivity.class));
                }
                else{
                    Toast.makeText(HubActivity.this, "Logout Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
