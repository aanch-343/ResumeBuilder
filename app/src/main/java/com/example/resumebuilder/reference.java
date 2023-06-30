package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class reference extends AppCompatActivity {
    EditText referenceName,jobTitle,companyName,email;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        referenceName=(EditText)findViewById(R.id.rn);
        jobTitle=(EditText)findViewById(R.id.jt);
        companyName=(EditText)findViewById(R.id.cn);
        email=(EditText)findViewById(R.id.email);
        done=(Button)findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> ref= new HashMap<String, Object>();
                ref.put("Reference",referenceName.getText().toString());
                ref.put("Job",jobTitle.getText().toString());
                ref.put("Company",companyName.getText().toString());
                ref.put("Email",email.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Reference").push().setValue(ref);
                Toast.makeText(reference.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}