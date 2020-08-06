package com.example.potterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurePupilsButton();
        configureSpellsButton();
        configureHousesButton();
        configureExitButton();
    }
//buttons for navigation on the main screen
    private void configurePupilsButton(){
        ImageButton pupilsButton = (ImageButton) findViewById(R.id.pupilsBtn);
        pupilsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PupilsActivity.class));

            }
        });
    }

    private void configureSpellsButton(){
        ImageButton spellsButton = (ImageButton) findViewById(R.id.spellsBtn);
        spellsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SpellsActivity.class));
            }
        });
    }

    private void configureHousesButton(){
        ImageButton housesButton = (ImageButton) findViewById(R.id.housesBtn);
        housesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HousesActivity.class));
            }
        });
    }

    private void configureExitButton(){
       ImageButton exitButton = (ImageButton) findViewById(R.id.exitBtn);
        exitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               System.exit(0);
            }
        });
    }
}