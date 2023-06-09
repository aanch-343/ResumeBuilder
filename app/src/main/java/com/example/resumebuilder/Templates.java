package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Templates extends AppCompatActivity {
ImageButton temp1,temp2,temp3,temp4,temp5,temp6;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        temp1=(ImageButton)findViewById(R.id.Template1);
        temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Templates.this, Template1.class);
                startActivity(i1);
            }
        });
    }
}