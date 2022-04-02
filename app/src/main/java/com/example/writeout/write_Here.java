package com.example.writeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class write_Here extends AppCompatActivity {

    //variables
    TextInputLayout regTitle, regAuthor, regCategory, regArticle; //_image
    Button publishBtn;
    //private EditText editText;

    // Write a message to the database
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_here);

        //editText = findViewById(R.id.article);
        regTitle= findViewById(R.id._title);
        regAuthor= findViewById(R.id._author);
        regCategory = findViewById(R.id._category);
        //image = findViewById(R.id.image);
        regArticle = findViewById(R.id._article);
        publishBtn = findViewById(R.id._publish);
    }
    
    //Edit Text OPTIONS
    public void buttonBold(View view){
        Spannable spannableString = new SpannableStringBuilder(regArticle.getEditText().getText());
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),
        regArticle.getEditText().getSelectionStart(),
        regArticle.getEditText().getSelectionEnd(),
        0);
        regArticle.getEditText().setText(spannableString);
    }
    public void buttonItalics(View view){
        Spannable spannableString = new SpannableStringBuilder(regArticle.getEditText().getText());
        spannableString.setSpan(new StyleSpan(Typeface.ITALIC),
                regArticle.getEditText().getSelectionStart(),
                regArticle.getEditText().getSelectionEnd(),
                0);
        regArticle.getEditText().setText(spannableString);
    }
    public void buttonUnderline(View view){
        Spannable spannableString = new SpannableStringBuilder(regArticle.getEditText().getText());
        spannableString.setSpan(new UnderlineSpan(),
                regArticle.getEditText().getSelectionStart(),
                regArticle.getEditText().getSelectionEnd(),
                0);
        regArticle.getEditText().setText(spannableString);
    }
    public void buttonNoFormat(View view){
        String stringText = regArticle.getEditText().getText().toString();
        regArticle.getEditText().setText(stringText);
    }
    public void buttonAlignLeft(View view){
        regArticle.setTextAlignment(view.TEXT_ALIGNMENT_TEXT_START);
        Spannable spannableString = new SpannableStringBuilder(regArticle.getEditText().getText());
        regArticle.getEditText().setText(spannableString);
    }
    public void buttonAlignCenter(View view){
        regArticle.setTextAlignment(view.TEXT_ALIGNMENT_CENTER);
        Spannable spannableString = new SpannableStringBuilder(regArticle.getEditText().getText());
        regArticle.getEditText().setText(spannableString);
    }
    public void buttonAlignRight(View view){
        regArticle.setTextAlignment(view.TEXT_ALIGNMENT_TEXT_END);
        Spannable spannableString = new SpannableStringBuilder(regArticle.getEditText().getText());
        regArticle.getEditText().setText(spannableString);
    }
    
    public  void back(View view){
        Intent intent = new Intent(write_Here.this,MyPage.class);
        startActivity(intent);
        finish();
    }

    //validate
    private Boolean validateAuthor(){
        String val = regAuthor.getEditText().getText().toString();
        if(val.isEmpty()){
            regAuthor.setError("Field cannot be empty");
            return false;
        }
        else {
            regAuthor.setError(null);
            regAuthor.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateCategory(){
        String val = regCategory.getEditText().getText().toString();
        if(val.isEmpty()){
            regCategory.setError("Field cannot be empty");
            return false;
        }
        else {
            regCategory.setError(null);
            regCategory.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateTitle(){
        String val = regTitle.getEditText().getText().toString();
        if(val.isEmpty()){
            regTitle.setError("Field cannot be empty");
            return false;
        }
        else {
            regTitle.setError(null);
            regTitle.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateArticle(){
        String val = regArticle.getEditText().getText().toString();
        if(val.isEmpty()){
            regArticle.setError("Field cannot be empty");
            return false;
        }
        else {
            regArticle.setError(null);
            regArticle.setErrorEnabled(false);
            return true;
        }
    }


    public void publish(View view) {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("articles");

        if(!validateAuthor() | !validateCategory() | !validateTitle() | !validateArticle()){
            return;
        }

        //Get all the values in string
        String author = regAuthor.getEditText().getText().toString();
        String category = regCategory.getEditText().getText().toString();
        String title = regTitle.getEditText().getText().toString();
        String article = regArticle.getEditText().getText().toString();
        //String image =_image.getText().toString();

        ArticleHelperClass helperClass = new ArticleHelperClass(author, category, title, article); //image

        reference.child(title).setValue(helperClass);
        Toast.makeText(write_Here.this,"Article published successfully!!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MyPage.class);
        startActivity(intent);
        finish();
    }
}