package com.example.flora;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class databaseClicked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_clicked);

        String name = getIntent().getStringExtra("Plant Name");
        String type = getIntent().getStringExtra("Plant Type");
        String water = getIntent().getStringExtra("Plant Water");

        TextView nameTextView = findViewById(R.id.pName);
        TextView typeTextView = findViewById(R.id.pType);
        TextView waterTextView = findViewById(R.id.pWater);

        nameTextView.setText(name);
        typeTextView.setText(type);
        waterTextView.setText(water);
    }
}
