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


public class SkillTempAdapter extends ArrayAdapter<Skilltemp> {

    private Context nContext;
    private int nResource;

    public SkillTempAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Skilltemp> objects) {
        super(context, resource, objects);
        this.nContext=context;
        this.nResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view= LayoutInflater.from(nContext).inflate(nResource,parent,false);

        TextView skill=view.findViewById(R.id.talent);
        skill.setText(getItem(position).getSkills());
        return view;
    }
}
