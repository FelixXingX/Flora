package com.example.flora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class databaseAdapter extends RecyclerView.Adapter<databaseAdapter.MyViewHolder> {
    private static final String TAG = "MainActivity";
    Context context;
    private ArrayList<Plant> plantDatabase;

    public databaseAdapter(Context context, ArrayList<Plant> plantDatabase) {
        this.context = context;
        this.plantDatabase = plantDatabase;
    }


    @NonNull
    @Override
    public databaseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.database_list_items, parent, false);
        return new databaseAdapter.MyViewHolder(view);
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView plantNameTxt;
        private TextView plantTypeTxt;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            plantNameTxt = itemView.findViewById(R.id.plantNameTxt);
            plantTypeTxt = itemView.findViewById(R.id.plantTypeTxt);
        }
    }
}
