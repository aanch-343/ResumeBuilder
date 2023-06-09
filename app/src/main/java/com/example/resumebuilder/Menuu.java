package com.example.resumebuilder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menuu extends AppCompatActivity {
    ImageButton profile,education,skills,objective,experience,reference;
    Button choose_template;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuu);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        profile=(ImageButton)findViewById(R.id.pd);
        education=(ImageButton)findViewById(R.id.edu);
        skills=(ImageButton)findViewById(R.id.skill) ;
        objective=(ImageButton)findViewById(R.id.obj) ;
        experience=(ImageButton)findViewById(R.id.exp) ;
        reference=(ImageButton)findViewById(R.id.ref) ;
        choose_template=(Button)findViewById(R.id.choose) ;
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
            profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Menuu.this,PersonalDetails.class) ;
                startActivity(i1);
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Menuu.this,Education.class);
                startActivity(i2);
            }
        });
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Menuu.this,Skillls.class);
                startActivity(i3);
            }
        });
        objective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(Menuu.this,Objective.class);
                startActivity(i4);
            }
        });
        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Menuu.this,Experience.class);
                startActivity(i5);
            }
        });
        reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(Menuu.this, reference.class);
                startActivity(i6);
            }
        });
        choose_template.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(Menuu.this,Templates.class);
                startActivity(i7);
            }
        });
    }
}