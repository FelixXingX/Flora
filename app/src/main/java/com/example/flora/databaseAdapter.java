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
    private final databasePlantInterface databaseInterface;
    Context context;
    private ArrayList<Plant> plantDatabase;

    public databaseAdapter(Context context, ArrayList<Plant> plantDatabase, databasePlantInterface databaseInterface) {
        this.context = context;
        this.plantDatabase = plantDatabase;
        this.databaseInterface = databaseInterface;
    }


    @NonNull
    @Override
    public databaseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.database_list_items, parent, false);
        return new databaseAdapter.MyViewHolder(view, databaseInterface);
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

        public MyViewHolder (@NonNull View itemView, databasePlantInterface databaseInterface) {
            super(itemView);
            plantNameTxt = itemView.findViewById(R.id.plantNameTxt);
            plantTypeTxt = itemView.findViewById(R.id.plantTypeTxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (databaseInterface != null) {
                        int pos = getAbsoluteAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            databaseInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
