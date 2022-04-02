package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Favorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
    }

    public void myPage(View view) {
        Intent intent = new Intent(Favorites.this,MyPage.class);
        startActivity(intent);
        finish();
    }

    public void othersPage(View view) {
        Intent intent = new Intent(Favorites.this,Others.class);
        startActivity(intent);
        finish();
    }
}