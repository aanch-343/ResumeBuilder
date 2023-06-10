package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Education extends AppCompatActivity {
    EditText degree,uni,grade,year;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}