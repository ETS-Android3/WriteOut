package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;



public class Signup extends AppCompatActivity {

    //variables
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Hooks to all xml elements in activity_signup.xml
        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.btn_signup);
        regToLoginBtn = findViewById(R.id.login_screen);


//        private void insertUserData(){
//            String name = Objects.requireNonNull(regName.getEditText()).getText().toString();
//            String username = regUsername.getEditText().getText().toString();
//            String email = regEmail.getEditText().getText().toString();
//            String phoneNo = regPhoneNo.getEditText().getText().toString();
//            String password = regPassword.getEditText().getText().toString();
//
//            UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
//
//
//            Toast.makeText(Signup.this, "Successfully Signed Up!!", Toast.LENGTH_SHORT).show();



        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}
