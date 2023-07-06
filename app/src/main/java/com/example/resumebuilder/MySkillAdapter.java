package com.example.resumebuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MySkillAdapter extends RecyclerView.Adapter<MySkillAdapter.MyViewHolder> {
    Context context;
    ArrayList<Templateskillmodel> list;

    public MySkillAdapter(Context context, ArrayList<Templateskillmodel> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MySkillAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.templateskill,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MySkillAdapter.MyViewHolder holder, int position) {
       Templateskillmodel templateskillmodel=list.get(position);
        holder.talent.setText(templateskillmodel.getTalent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView talent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
          talent=itemView.findViewById(R.id.talent);

        }
    }

}
