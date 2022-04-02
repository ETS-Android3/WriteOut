package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class ForgetPassword extends AppCompatActivity {

    TextInputLayout email;
    Button signInButton, forgetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        //Hooks to all xml elements in activity_login.xml
        signInButton =findViewById(R.id.btn_login);
        email =findViewById(R.id.text_email);
        forgetButton =findViewById(R.id.btn_reset);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}