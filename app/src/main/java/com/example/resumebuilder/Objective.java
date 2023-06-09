package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Objective extends AppCompatActivity {
    EditText obj;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        obj=(EditText)findViewById(R.id.objective);
        done=(Button)findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> o=new HashMap<String, Object>();
                o.put("objective",obj.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Objective").push().setValue(o);
                Toast.makeText(Objective.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(Objective.this,Menuu.class) ;
                startActivity(i1);
            }
        });
    }
}