package com.example.flora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button addButton;
    ImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.backgroundMain);
        view.setImageResource(R.drawable.background);

        ImageView myImageView = (ImageView) findViewById(R.id.plantLogo);
        myImageView.setImageResource(R.drawable.plantlogo);


        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, addMenu.class));
            }
        });

    }

}