package com.example.flora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class databaseAdapter extends RecyclerView.Adapter<databaseAdapter.MyViewHolder> {
    private static final String TAG = "MainActivity";
    private ArrayList<Plant> plantDatabase;
    public databaseAdapter(ArrayList<Plant> plantDatabase) {
        this.plantDatabase = plantDatabase;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView plantNameTxt;
        private TextView plantTypeTxt;

        public MyViewHolder (@NonNull View view) {
            super(view);
            plantNameTxt = view.findViewById(R.id.plantNameTxt);
            plantTypeTxt = view.findViewById(R.id.plantTypeTxt);
        }

    }

    @NonNull
    @Override
    public databaseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.database_list_items,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull databaseAdapter.MyViewHolder holder, int position) {
        String name = plantDatabase.get(position).getPlantName();
        holder.plantNameTxt.setText(name);
        String type = plantDatabase.get(position).getPlantType();
        holder.plantTypeTxt.setText(type);
    }

    @Override
    public int getItemCount() {
        return plantDatabase.size();
    }

}
