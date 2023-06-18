package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Skillls extends AppCompatActivity {
    EditText skill;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skillls);
//        getSupportActionBar().setTitle("Skills");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        skill=(EditText)findViewById(R.id.skill);
        done=(Button)findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> s=new HashMap<String, Object>();
                s.put("skill",skill.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Skills").push().setValue(s);
            }
        });
    }
}