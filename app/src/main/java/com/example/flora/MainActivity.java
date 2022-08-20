package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Plant> savedPlantObjects = new ArrayList<Plant>(); // users personal plants
    private ArrayList<Plant> plantDatabase = new ArrayList<Plant>(); // reads from the database and stores it in an array
    private ArrayList<String> lines = new ArrayList<>();  // Data from Database
    private static final String TAG = "MainActivity";

    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView myImageView = (ImageView) findViewById(R.id.plantLogo);
        myImageView.setImageResource(R.drawable.plantlogo);

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

        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, addMenu.class));
            }
        });

    }
}