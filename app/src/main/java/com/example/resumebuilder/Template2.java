package com.example.resumebuilder;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


public class Template2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


    }
}
