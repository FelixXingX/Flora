package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class addMenu extends AppCompatActivity {

    Button manualButton;
    Button databaseButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_menu);

        manualButton = findViewById(R.id.manualButton);
        databaseButton = findViewById(R.id.databaseButton);

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
    }
}
