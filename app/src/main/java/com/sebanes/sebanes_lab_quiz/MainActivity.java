package com.sebanes.sebanes_lab_quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etAuthor, etQuote;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor = (EditText) findViewById(R.id.etAuthor);
        etQuote = (EditText) findViewById(R.id.etQuote);

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_WORLD_READABLE);
    }

    public void save(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("quote", etQuote.getText().toString());
        editor.putString("author", etAuthor.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_LONG).show();
    }

    public void next(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("author", etAuthor.getText().toString());
        startActivity(intent);
    }
}
