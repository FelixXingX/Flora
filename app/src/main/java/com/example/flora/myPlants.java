package com.example.flora;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.view.View;
import android.widget.Button;

public class myPlants extends AppCompatActivity {

    Button backMainMenuButton;

    private ArrayList<Plant> savedPlantObjects = new ArrayList<Plant>(); // users personal plants
    private static final String TAG = "MainActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plants);

        String name = getIntent().getStringExtra("Plant Name");
        if (name != null) {
            String type = getIntent().getStringExtra("Plant Type");
            String water = getIntent().getStringExtra("Plant Water");
            savedPlantObjects.add(new Plant (name,type,water));
        }

        if (savedPlantObjects.size() > 1) {
            Collections.sort(savedPlantObjects, new Comparator<Plant>(){
                public int compare (Plant o1, Plant o2) {
                    int comp = o1.getDaysUntilWater() - o2.getDaysUntilWater();
                    return comp;
                }
            });
        }
        RecyclerView recyclerView = findViewById(R.id.savedRecyclerView);
        myPlantAdapter adapter = new myPlantAdapter(this, savedPlantObjects);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        backMainMenuButton = findViewById(R.id.backMainMenu2);

        backMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(myPlants.this, MainActivity.class));
            }
        });
    }
}
