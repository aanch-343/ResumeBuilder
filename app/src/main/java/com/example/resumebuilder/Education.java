package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
        degree=(EditText)findViewById(R.id.course);
        uni=(EditText)findViewById(R.id.school);
        grade=(EditText)findViewById(R.id.grade);
        year=(EditText)findViewById(R.id.year);
        done=(Button)findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> e= new HashMap <String,Object>();
                e.put("degree",degree.getText().toString());
                e.put("uni",uni.getText().toString());
                e.put("grade",grade.getText().toString());
                e.put("year",year.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Education").push().setValue(e);
            }
        });
    }
}