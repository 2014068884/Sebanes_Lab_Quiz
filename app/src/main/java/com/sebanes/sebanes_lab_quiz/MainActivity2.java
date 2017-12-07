package com.sebanes.sebanes_lab_quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    String data;
    TextView author, quote;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        author = (TextView) findViewById(R.id.tvAuthor2);
        quote = (TextView) findViewById(R.id.tvQuotes2);

        data = getIntent().getStringExtra("author");

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_WORLD_READABLE);

        String authors = sharedPreferences.getString("author", "");
        String quotes = sharedPreferences.getString("quote", "");

        author.setText(authors);
        quote.setText(quotes);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
