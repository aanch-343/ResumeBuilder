package com.example.resumebuilder;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.HashMap;

public class Education extends AppCompatActivity {
    ArrayList<EducationModel> arrEducation=new ArrayList<>();
    FloatingActionButton btn;
    RecyclerAdapter1 adapter;
    DatabaseReference databaseReference;
    //private DatabaseReference db=FirebaseDatabase.getInstance().getReference("Education");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclervieweducation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        RecyclerView recyclerView=findViewById(R.id.recyclereducation);
        btn=findViewById(R.id.add);
       Button done=findViewById(R.id.Done);
       done.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(Education.this, "Education Details Entered", Toast.LENGTH_SHORT).show();
               Intent i1=new Intent(Education.this,Menuu.class) ;
               startActivity(i1);
           }
       });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(Education.this);
                dialog.setContentView(R.layout.addeducation);
                EditText edtyear=dialog.findViewById(R.id.edtyear);
                EditText edtschool=dialog.findViewById(R.id.edtschool);
                EditText edtcourse=dialog.findViewById(R.id.edtcourse);
                EditText edtgrade=dialog.findViewById(R.id.edtgrade);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String year=edtyear.getText().toString();
                        String school=edtschool.getText().toString();
                        String grade=edtgrade.getText().toString();
                        String course=edtcourse.getText().toString();
                        arrEducation.add(new EducationModel(school,year,course,grade));
                        HashMap<String,Object> ref= new HashMap<String, Object>();
                        ref.put("Year",edtyear.getText().toString());
                        ref.put("Grade",edtgrade.getText().toString());
                        ref.put("School",edtschool.getText().toString());
                        ref.put("Course",edtcourse.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("Education").push().setValue(ref);
                        Toast.makeText(Education.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                        adapter.notifyItemInserted(arrEducation.size()-1);
                        recyclerView.scrollToPosition(arrEducation.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

//        arrEducation.add(new EducationModel("","","",""));
//        arrEducation.add(new EducationModel("","","",""));
//        arrEducation.add(new EducationModel("","","",""));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter1(this,arrEducation);
        recyclerView.setAdapter(adapter);

    }
}
