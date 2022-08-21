package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class database extends AppCompatActivity implements databasePlantInterface{
    private ArrayList<Plant> plantDatabase = new ArrayList<Plant>(); // reads from the database and stores it in an array
    private ArrayList<String> lines = new ArrayList<>();  // Data from Database
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        RecyclerView recyclerView = findViewById(R.id.databaseRecyclerView);
        setupPlantModels();
        databaseAdapter adapter = new databaseAdapter(this, plantDatabase, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }


    private void setupPlantModels(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("Plant Database.txt")));
            while (br.ready()) {
                lines.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Organizes database into Object Array
        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split(":");
            plantDatabase.add(new Plant(split[0], split[1], split[2]));
        }

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, plantDatabase.get(i).getPlantName());
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(database.this, databaseClicked.class);
        String str;
        int num = plantDatabase.get(position).getDaysPerWater();
        if (num != 1){
            str = plantDatabase.get(position).getPlantName() + "'s\n needs to be watered \n every " + num + " days.";
        } else {
            str = plantDatabase.get(position).getPlantName() + "'s\n needs to be watered \n everyday.";
        }

        intent.putExtra("Plant Name", plantDatabase.get(position).getPlantName());
        intent.putExtra("Plant Type", plantDatabase.get(position).getPlantType());
        intent.putExtra("Plant Water", str);

        startActivity(intent);
    }
}
