package com.example.flora;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myPlantAdapter extends RecyclerView.Adapter<myPlantAdapter.MyViewHolder> {
    //private final savedPlantInterface savedInterface;
    Context context;
    private ArrayList<Plant> savedPlantObjects;
    private static final String TAG = "MainActivity";

    public myPlantAdapter(Context context, ArrayList<Plant> savedPlantObjects) { //savedPlantInterface savedInterface
        this.context = context;
        this.savedPlantObjects = savedPlantObjects;
        //this.savedPlantInterface = savedInterface;
    }


    @NonNull
    @Override
    public myPlantAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_plants_layout, parent, false);
        return new myPlantAdapter.MyViewHolder(view); //savedInterface
    }

    @Override
    public void onBindViewHolder(@NonNull myPlantAdapter.MyViewHolder holder, int position) {
        String name = savedPlantObjects.get(position).getPlantName();
        holder.plantNameTxt.setText(name);
        String type = String.valueOf(savedPlantObjects.get(position).getDaysUntilWater());
        holder.plantWaterTxt.setText(type);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, String.valueOf(savedPlantObjects.size()));
        return savedPlantObjects.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView plantNameTxt;
        private TextView plantWaterTxt;

        public MyViewHolder (@NonNull View itemView) { // savedPlantInterface savedInterface
            super(itemView);
            plantNameTxt = itemView.findViewById(R.id.textView5);
            plantWaterTxt = itemView.findViewById(R.id.textView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*
                    if (savedInterface != null) {
                        int pos = getAbsoluteAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            savedInterface.onItemsClick(pos);
                        }
                    }

                     */
                }
            });
        }
    }
}
