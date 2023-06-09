package com.example.resumebuilder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button create,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create=(Button)findViewById(R.id.create);
        view=(Button)findViewById(R.id.view);
//        ActionBar actionBar;
//        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
//        ColorDrawable colorDrawable
//                = new ColorDrawable(Color.parseColor("#005691"));

        // Set BackgroundDrawable
//        actionBar.setBackgroundDrawable(colorDrawable);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(MainActivity.this,Menuu.class);
                startActivity(i1);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(MainActivity.this,ViewResume.class);
                startActivity(i2);
            }
        });

    }
}