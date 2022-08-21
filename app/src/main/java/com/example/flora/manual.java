package com.example.flora;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.io.File;

public class manual extends AppCompatActivity {

    String name, type;
    int water;

    EditText plantName;
    EditText plantType;
    EditText waterLevel;

    Button submitButton;

    ImageView view;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);

        plantName = (EditText) findViewById(R.id.plantName);
        plantType = (EditText) findViewById(R.id.plantType);
        waterLevel = (EditText) findViewById(R.id.waterLevel);

        submitButton = findViewById(R.id.Submit);

        view = findViewById(R.id.backgroundManual);
        view.setImageResource(R.drawable.background);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = plantName.getText().toString();
                type = plantType.getText().toString();
                water = Integer.valueOf(waterLevel.getText().toString());

                String newPlant = name + ":" + type + ":" + water;
                writeToFile("manualPlant.txt",newPlant);

                startActivity(new Intent(manual.this, addMenu.class));
            }
        });
    }

    public void writeToFile(String fileName, String content){
        File path = getApplicationContext().getFilesDir();
        try{
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
