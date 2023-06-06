package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.lang.ref.Reference;

public class Menu extends AppCompatActivity {
FrameLayout profile,education,skills,objective,experience,reference;
Button choose_template;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        profile=(FrameLayout)findViewById(R.id.frame1);
        education=(FrameLayout)findViewById(R.id.frame2);
       skills=(FrameLayout)findViewById(R.id.frame3) ;
        objective=(FrameLayout)findViewById(R.id.frame4) ;
        experience=(FrameLayout)findViewById(R.id.frame5) ;
        reference=(FrameLayout)findViewById(R.id.frame6) ;
        choose_template=(Button)findViewById(R.id.button) ;
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i1=new Intent(Menu.this,PersonalDetails.class) ;
               startActivity(i1);
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Menu.this,Education.class);
                startActivity(i2);
            }
        });
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Menu.this,Skillls.class);
                startActivity(i3);
            }
        });
        objective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(Menu.this,Objective.class);
                startActivity(i4);
            }
        });
        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(Menu.this,Experience.class);
                startActivity(i5);
            }
        });
       reference.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i6=new Intent(Menu.this, reference.class);
               startActivity(i6);
           }
       });
       choose_template.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i7=new Intent(Menu.this,Templates.class);
               startActivity(i7);
           }
       });

    }
}