package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class databaseClicked extends AppCompatActivity {

    Button addMyPlant;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_clicked);
        String name = getIntent().getStringExtra("Plant Name");
        String type = getIntent().getStringExtra("Plant Type");
        String water = getIntent().getStringExtra("Plant Water");

        String untilWater = getIntent().getStringExtra("Until Water");

        TextView nameTextView = findViewById(R.id.pName);
        TextView typeTextView = findViewById(R.id.pType);
        TextView waterTextView = findViewById(R.id.pWater);

        nameTextView.setText(name);
        typeTextView.setText(type);
        waterTextView.setText(water);

        addMyPlant = findViewById(R.id.addMyPlants);

        addMyPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(databaseClicked.this, myPlants.class);
                intent.putExtra("Plant Name", name);
                intent.putExtra("Plant Type", type);
                intent.putExtra("Plant Water", untilWater);
                startActivity(intent);
            }
        });
    }
}
