package com.example.resumebuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Experience extends AppCompatActivity {
    ArrayList<ExperienceModel> arrExperience=new ArrayList<>();
    FloatingActionButton btn;
    RecyclerAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerexperience);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        RecyclerView recyclerView=findViewById(R.id.re);
        btn=findViewById(R.id.add);
        Button done=findViewById(R.id.Done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Experience.this, "Experience is a Gateway to Any Job", Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(Experience.this,Menuu.class) ;
                startActivity(i1);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(Experience.this);
                dialog.setContentView(R.layout.addexperience);
                EditText edtcname=dialog.findViewById(R.id.edtcname);
                EditText edtjtitle=dialog.findViewById(R.id.edtJtitle);
                EditText edtdur=dialog.findViewById(R.id.edtDur);
//                EditText edtdetails=dialog.findViewById(R.id.edtdetail);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cname=edtcname.getText().toString();
                        String jtitle=edtjtitle.getText().toString();
                        String details=edtdur.getText().toString();
                        String dur=edtdur.getText().toString();
                        arrExperience.add(new ExperienceModel(cname,jtitle,dur));
                        HashMap<String,Object> ref= new HashMap<String, Object>();
                        ref.put("Company",edtcname.getText().toString());
                        ref.put("Job",edtjtitle.getText().toString());
                        ref.put("Dur",edtdur.getText().toString());
//                        ref.put("Details",edtdetails.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("Experience").push().setValue(ref);
                        Toast.makeText(Experience.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                        adapter.notifyItemInserted(arrExperience.size()-1);
                        recyclerView.scrollToPosition(arrExperience.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

       // arrExperience.add(new ExperienceModel("","","",""));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter3(this,arrExperience);
        recyclerView.setAdapter(adapter);

    }
}
