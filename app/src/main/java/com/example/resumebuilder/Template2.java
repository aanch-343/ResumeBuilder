package com.example.resumebuilder;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Template2 extends AppCompatActivity {
  RecyclerView recyclerView1,recyclerView2,recyclerView3;
  MyEduAdapter myEduAdapter;
  MySkillAdapter myskillAdapter;
  ArrayList<Templateedumodel> templateedumodelArrayList;
  ArrayList<Templateskillmodel> templateskillmodelArrayList;
  ArrayList<TemplateExpModel> templateExpModelArrayList;
    TextView name,phone,address,email,job,company,duration,detail,companyref,jobref,emailref,nameref,school,course,year,grade,linkdin,desc;
    DatabaseReference personalDetails,objective,skills,Experience,Education,Reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        name=(TextView)findViewById(R.id.name);
        phone=(TextView)findViewById(R.id.phone);
        address=(TextView)findViewById(R.id.address);
        email=(TextView)findViewById(R.id.email);
        linkdin=(TextView) findViewById(R.id.linkedIn);
        desc=(TextView)findViewById(R.id.objective);
        nameref=(TextView)findViewById(R.id.referenceName);
        companyref=(TextView)findViewById(R.id.companyref);
        jobref=(TextView)findViewById(R.id.jobref);
        emailref=(TextView)findViewById(R.id.emailRef);
        recyclerView1=findViewById(R.id.recyclerView1);
        recyclerView2=findViewById(R.id.recyclerView2);
        recyclerView3=findViewById(R.id.recyclerView3);
        personalDetails= FirebaseDatabase.getInstance().getReference().child("Personal Details");
        Query query=personalDetails.limitToLast(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();

                String fname=latestSnapshot.child("name").getValue(String.class);
                String fphone=latestSnapshot.child("phone").getValue(String.class);
                String fadd=latestSnapshot.child("address").getValue(String.class);
                String fmail=latestSnapshot.child("email").getValue(String.class);
                String flinkedin=latestSnapshot.child("LinkedIn").getValue(String.class);

                name.setText(fname);
                phone.setText(fphone);
                address.setText(fadd);
                email.setText(fmail);
                linkdin.setText(flinkedin);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        objective=FirebaseDatabase.getInstance().getReference().child("Objective");
        Query query1=objective.limitToLast(1);
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
                    String fdesc=latestSnapshot.child("objective").getValue(String.class);
                    desc.setText(fdesc);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Reference= FirebaseDatabase.getInstance().getReference().child("Reference");
        Query query2=Reference.limitToLast(1);
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();


                String namerefer=latestSnapshot.child("Reference").getValue(String.class);
                String jobrefer=latestSnapshot.child("Job").getValue(String.class);
                String companyrefer=latestSnapshot.child("Company").getValue(String.class);
                String emailrefer=latestSnapshot.child("Email").getValue(String.class);
                nameref.setText(namerefer);
               jobref.setText(jobrefer);
                companyref.setText(companyrefer);
               emailref.setText(emailrefer);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        Education=FirebaseDatabase.getInstance().getReference("Education");
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        templateedumodelArrayList=new ArrayList<>();
        myEduAdapter=new MyEduAdapter(this,templateedumodelArrayList);
        recyclerView1.setAdapter(myEduAdapter);
        Education.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Templateedumodel templateedumodel=dataSnapshot.getValue(Templateedumodel.class);
                    templateedumodelArrayList.add(templateedumodel);
                }
                myEduAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       skills=FirebaseDatabase.getInstance().getReference("Skills");
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        templateskillmodelArrayList=new ArrayList<>();
        myskillAdapter=new MySkillAdapter(this,templateskillmodelArrayList);
        recyclerView3.setAdapter(myskillAdapter);
       skills.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                   Templateskillmodel templateskillmodel=dataSnapshot.getValue(Templateskillmodel.class);
                   templateskillmodelArrayList.add(templateskillmodel);
                }
                myskillAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
