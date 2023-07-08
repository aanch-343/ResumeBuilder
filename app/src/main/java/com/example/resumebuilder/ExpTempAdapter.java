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


public class ExpTempAdapter extends ArrayAdapter<Exptemp> {

    private Context nContext;
    private int nResource;

    public ExpTempAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Exptemp> objects) {
        super(context, resource, objects);
        this.nContext=context;
        this.nResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view= LayoutInflater.from(nContext).inflate(nResource,parent,false);

        TextView company=view.findViewById(R.id.company);
        TextView job=view.findViewById(R.id.job);
        TextView dur=view.findViewById(R.id.dur);
        TextView detail=view.findViewById(R.id.details);
        company.setText(getItem(position).getCompany());
        job.setText(getItem(position).getJob());
       dur.setText(getItem(position).getDur());
        detail.setText(getItem(position).getDetails());
        return view;
    }
}
