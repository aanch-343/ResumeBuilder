package com.example.resumebuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyEduAdapter extends RecyclerView.Adapter<MyEduAdapter.MyViewHolder> {
    Context context;
    ArrayList<Templateedumodel> list;

    public MyEduAdapter(Context context, ArrayList<Templateedumodel> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyEduAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.templateeducation,parent,false);
     return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyEduAdapter.MyViewHolder holder, int position) {
Templateedumodel templateedumodel=list.get(position);
holder.course.setText(templateedumodel.getCourse());
holder.year.setText(templateedumodel.getYear());
holder.grade.setText(templateedumodel.getGrade());
holder.school.setText( templateedumodel.getSchool());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
         TextView course,year,grade,school;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            course=itemView.findViewById(R.id.course);
           year=itemView.findViewById(R.id.year);
           grade=itemView.findViewById(R.id.grade);
            school=itemView.findViewById(R.id.school);
        }
    }

}
