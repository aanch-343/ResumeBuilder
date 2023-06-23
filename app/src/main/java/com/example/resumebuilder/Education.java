package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Education extends AppCompatActivity {
    ArrayList<EducationModel> arrEducation=new ArrayList<>();
    FloatingActionButton btn;
    RecyclerAdapter1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclervieweducation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        RecyclerView recyclerView=findViewById(R.id.recyclereducation);
        btn=findViewById(R.id.add);
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
                        adapter.notifyItemInserted(arrEducation.size()-1);
                        recyclerView.scrollToPosition(arrEducation.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        arrEducation.add(new EducationModel("","","",""));
        arrEducation.add(new EducationModel("","","",""));
        arrEducation.add(new EducationModel("","","",""));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter1(this,arrEducation);
        recyclerView.setAdapter(adapter);

    }
}
