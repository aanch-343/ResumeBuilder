package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewResume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resume);
        getSupportActionBar().setTitle("View Resume");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}