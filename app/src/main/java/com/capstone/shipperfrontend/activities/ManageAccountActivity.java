package com.capstone.shipperfrontend.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.capstone.shipperfrontend.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.Task;

public class ManageAccountActivity extends AppCompatActivity {

    //String name;
    String email;
    String current_;

    TextView userEmailtv;
    EditText changeEmail, pass, confirmPass, currentPassword;
    Button submit, delete;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);
        setupUIViews();
        retrieveUser();
        userEmailtv.setText(email);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_ = changeEmail.getText().toString().trim();
                String password_ = pass.getText().toString().trim();
                String password_c = confirmPass.getText().toString().trim();
                current_ = currentPassword.getText().toString().trim();

                if(current_ != "" && email_ != "" && password_ == password_c && password_ != "") {
                    reauthenticateUser(email, current_);
                    updateEmail(email_);
                    updatePassword(password_);
                }
                else if(current_ != "" && email_ != "") {
                    reauthenticateUser(email, current_);
                    updateEmail(email_);
                }
                else if(current_ != "" && password_ == password_c && password_ != "") {
                    reauthenticateUser(email, current_);
                    updatePassword(password_);
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_ = currentPassword.getText().toString().trim();
                reauthenticateUser(email, current_);
                deleteAccount();
            }
        });
    }

    public void updateEmail(String email_){
        user.updateEmail(email_).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Log.d(TAG, "User email address updated.");
                            Toast.makeText(ManageAccountActivity.this, "Updated email successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ManageAccountActivity.this, LoginActivity.class));
                        }
                        else
                            Toast.makeText(ManageAccountActivity.this, "Current password incorrect!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void deleteAccount(){
        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Log.d(TAG, "User account deleted.");
                            Toast.makeText(ManageAccountActivity.this, "Delete account successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ManageAccountActivity.this, LoginActivity.class));
                        }
                        else
                            Toast.makeText(ManageAccountActivity.this, "Current password incorrect!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void updatePassword(String password_){
        user.updatePassword(password_).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    //Log.d(TAG, "User email address updated.");
                    Toast.makeText(ManageAccountActivity.this, "Update password successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ManageAccountActivity.this, LoginActivity.class));
                }
                else
                    Toast.makeText(ManageAccountActivity.this, "Current password incorrect!", Toast.LENGTH_SHORT).show();
            }
        });
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

    public void reauthenticateUser(String _email, String _password){
        //user = FirebaseAuth.getInstance().getCurrentUser();

        // Get auth credentials from the user for re-authentication. The example below shows
        // email and password credentials but there are multiple possible providers,
        // such as GoogleAuthProvider or FacebookAuthProvider.
        AuthCredential credential = EmailAuthProvider.getCredential(_email, _password);

        // Prompt the user to re-provide their sign-in credentials
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //Log.d(TAG, "User re-authenticated.");
                    }
                });
    }

    private void setupUIViews()
    {
        userEmailtv = (TextView)findViewById(R.id.email);
        changeEmail = (EditText)findViewById(R.id.changeEmail);
        pass = (EditText)findViewById(R.id.updatePassword);
        confirmPass = (EditText)findViewById(R.id.confirmPass);
        currentPassword = (EditText)findViewById(R.id.currentPassword);
        submit = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
    }
}