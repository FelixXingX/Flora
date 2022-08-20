package com.example.flora;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class manual extends AppCompatActivity {

    String name, type;
    int water;

    EditText plantName;
    EditText plantType;
    EditText waterLevel;

    Button submitButton;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);

        plantName = (EditText) findViewById(R.id.plantName);
        plantType = (EditText) findViewById(R.id.plantType);
        waterLevel = (EditText) findViewById(R.id.waterLevel);

        submitButton = findViewById(R.id.Submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = plantName.getText().toString();
                type = plantType.getText().toString();
                water = Integer.valueOf(waterLevel.getText().toString());
                startActivity(new Intent(manual.this, addMenu.class));
            }
        });
    }
}
