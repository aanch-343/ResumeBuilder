package com.example.resumebuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EduTempAdapter extends ArrayAdapter<Edutemp>{

    private  Context nContext;
    private int nResource;

    public EduTempAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Edutemp> objects) {
        super(context, resource, objects);
        this.nContext=context;
        this.nResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view= LayoutInflater.from(nContext).inflate(nResource,parent,false);

        TextView course=view.findViewById(R.id.course);
        TextView school=view.findViewById(R.id.school);
        TextView year=view.findViewById(R.id.year);
        TextView grade=view.findViewById(R.id.grade);
        course.setText(getItem(position).getCourse());
        school.setText(getItem(position).getSchool());
        grade.setText(getItem(position).getGrade());
        year.setText(getItem(position).getYear());
return view;
    }
}
