package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Skillls extends AppCompatActivity {
    ArrayList<SkilllsModel> arrSkills=new ArrayList<>();
    FloatingActionButton btn;
    RecyclerAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerskill);
        RecyclerView recyclerView=findViewById(R.id.recyclerskill);
        arrSkills = new ArrayList<>();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        btn=findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(Skillls.this);
                dialog.setContentView(R.layout.addskill);
                EditText edtskill=dialog.findViewById(R.id.edtskill);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String skill=edtskill.getText().toString();
                        arrSkills.add(new SkilllsModel(skill));
                        adapter.notifyItemInserted(arrSkills.size()-1);
                        recyclerView.scrollToPosition(arrSkills.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

            arrSkills.add(new SkilllsModel(""));
            arrSkills.add(new SkilllsModel(""));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter2(this,arrSkills);
        recyclerView.setAdapter(adapter);

    }
}}
