package com.example.project1.viewholder;

import android.util.SparseBooleanArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlarmViewHolder extends RecyclerView.ViewHolder{

    public long id;
    public long timeView;
    public String labelView;
    public SparseBooleanArray allDays;
    public boolean isEnabled;
    public String med;
    public String rec;
    public boolean status;

    public AlarmViewHolder(@NonNull View itemView) {
        super(itemView);


        
    }
}
