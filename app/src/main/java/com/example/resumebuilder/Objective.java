package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Objective extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);
        getSupportActionBar().setTitle("Objectives");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}