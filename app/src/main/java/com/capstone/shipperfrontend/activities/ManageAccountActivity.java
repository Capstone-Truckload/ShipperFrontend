package com.capstone.shipperfrontend.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.capstone.shipperfrontend.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.Task;

public class ManageAccountActivity extends AppCompatActivity {

    //String name;
    String email;

    TextView userEmailtv;
    EditText changeEmail, pass, confirmPass;
    Button submit, delete;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);
        setupUIViews();
        retrieveUser();
        userEmailtv.setText(email);
    }

    public void setEmail(){
        user.updateEmail(changeEmail.toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Log.d(TAG, "User email address updated.");
                        }
                    }
                });
    }

    public void deleteAccount(){

    }

    public void updatePassword(){

    }

    public void updateEmail(){

    }

    void retrieveUser(){
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            // Name, email address, and profile photo Url
            //name = user.getDisplayName();
            email = user.getEmail();
        } else {
            // No user is signed in
        }
    }

    private void setupUIViews()
    {
        userEmailtv = (TextView)findViewById(R.id.email);
        changeEmail = (EditText)findViewById(R.id.changeEmail);
        pass = (EditText)findViewById(R.id.updatePassword);
        confirmPass = (EditText)findViewById(R.id.confirmPass);
        submit = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
    }
}