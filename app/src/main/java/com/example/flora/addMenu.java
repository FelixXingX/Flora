package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class addMenu extends AppCompatActivity {

    Button manualButton;
    Button databaseButton;
    Button back;
    ImageView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu);

        manualButton = findViewById(R.id.manualButton);
        databaseButton = findViewById(R.id.databaseButton);
        back = findViewById(R.id.back);
        view = findViewById(R.id.background);
        view.setImageResource(R.drawable.background);

        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addMenu.this, manual.class));
            }
        });

        databaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addMenu.this, database.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addMenu.this, MainActivity.class));
            }
        });

    }
}
