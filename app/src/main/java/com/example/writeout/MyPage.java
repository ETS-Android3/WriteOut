package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MyPage extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        recyclerView = (RecyclerView)findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ArticleHelperClass> options =
                new FirebaseRecyclerOptions.Builder<ArticleHelperClass>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("articles"), ArticleHelperClass.class)
                .build();

        myAdapter = new MyAdapter(options);
        recyclerView.setAdapter(myAdapter);

    }

    public void profile(View view) {
        Intent intent = new Intent(MyPage.this,Profile.class);
        startActivity(intent);
        finish();
    }

//    public void read(View view) {
//        Intent intent = new Intent(MyPage.this,Read.class);
//        startActivity(intent);
//        finish();
//    }

    public void Write(View view) {
        Intent intent = new Intent(MyPage.this,write_Here.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }

    public void othersPage(View view) {
        Intent intent = new Intent(MyPage.this,Others.class);
        startActivity(intent);
        finish();
    }

    public void favorites(View view) {
        Intent intent = new Intent(MyPage.this,Favorites.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str){
        FirebaseRecyclerOptions<ArticleHelperClass> options =
                new FirebaseRecyclerOptions.Builder<ArticleHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("articles").orderByChild("title").startAt(str).endAt(str+"~"), ArticleHelperClass.class)
                        .build();

        myAdapter = new MyAdapter(options);
        myAdapter.startListening();
        recyclerView.setAdapter(myAdapter);
    }

    public void notify(View view) {
        Intent intent = new Intent(MyPage.this,Read.class);
        startActivity(intent);
    }
}