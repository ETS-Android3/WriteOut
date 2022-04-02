package com.example.writeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {

    TextInputLayout username, password;
    Button signInButton, signupScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Hooks to all xml elements in activity_login.xml
        signupScreen =findViewById(R.id.signup_screen);
        signInButton =findViewById(R.id.btn_signin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //SignIn
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username_ =username.getEditText().getText().toString();
                String password_ =password.getEditText().getText().toString();

                if(!username_.isEmpty()){
                    username.setError(null);
                    username.setErrorEnabled(false);
                    if (!password_.isEmpty()){
                        password.setError(null);
                        password.setErrorEnabled(false);
                        
                        final String username_data =username.getEditText().getText().toString();
                        final String password_data =password.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("users");

                        Query check_username = databaseReference.orderByChild("username").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                if (snapshot.exists()){
                                    username.setError(null);
                                    username.setErrorEnabled(false);
                                    String passwordCheck = snapshot.child(username_data).child("password").getValue(String.class);
                                    if (passwordCheck.equals(password_data)){
                                      password.setError(null);
                                      password.setErrorEnabled(false);
                                        Toast.makeText(getApplicationContext(),"SignIn Successfully!!",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        password.setError("incorrect password");
                                    }
                                }else {
                                    username.setError("user does not exists");
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }else {
                        password.setError("please enter the password");
                    }
                }else{
                    username.setError("please enter the username");
                }
            }
        });

        //move to signup screen
        signupScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Signup.class);
                startActivity(i);
                finish();
            }
        });

    }
}
