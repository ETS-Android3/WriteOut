package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Read extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
    }

    public void back2(View view) {
        Intent intent = new Intent(Read.this,MyPage.class);
        startActivity(intent);
        finish();
    }
}