package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Others extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
    }

    public void myPage(View view) {
        Intent intent = new Intent(Others.this,MyPage.class);
        startActivity(intent);
        finish();
    }

    public void favorites(View view) {
        Intent intent = new Intent(Others.this,Favorites.class);
        startActivity(intent);
        finish();
    }
}