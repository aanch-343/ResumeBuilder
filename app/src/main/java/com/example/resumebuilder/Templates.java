package com.example.resumebuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        temp2=(ImageButton)findViewById(R.id.Template2);
        temp3=(ImageButton)findViewById(R.id.Template3);



        temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent i1=new Intent(Templates.this, Template1.class);
                startActivity(i1);

            }
        });
        temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent i2=new Intent(Templates.this, Template2.class);
                startActivity(i2);

            }
        });
        temp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent i2=new Intent(Templates.this, Template3.class);
                startActivity(i2);

            }
        });


    }

}