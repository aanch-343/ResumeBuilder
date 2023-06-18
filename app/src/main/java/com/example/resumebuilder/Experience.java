package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Experience extends AppCompatActivity {
    EditText compName,jobTitle,startDate,endDate,details;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        compName=(EditText)findViewById(R.id.cn);
        jobTitle=(EditText)findViewById(R.id.jt);
        startDate=(EditText)findViewById(R.id.sd);
        endDate=(EditText)findViewById(R.id.ed);
        details=(EditText)findViewById(R.id.details);
        done=(Button)findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> exp = new HashMap<String, Object>();
                exp.put("Company Name",compName.getText().toString());
                exp.put("Job Title",jobTitle.getText().toString());
                exp.put("Start Date",startDate.getText().toString());
                exp.put("End Date",endDate.getText().toString());
                exp.put("Details",details.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Experience").push().setValue(exp);
            }
        });
    }
}