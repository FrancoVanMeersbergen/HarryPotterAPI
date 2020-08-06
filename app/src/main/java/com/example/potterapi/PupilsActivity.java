package com.example.potterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PupilsActivity extends AppCompatActivity {
    Button click;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pupils);
        configureBackButton();
       configureSortingButton();
// need to assign the button and Text View to the button and Text View used in the xml file because it needs to affect those specific objects
        click = findViewById(R.id.fetchDataBtn);
        data = (TextView) findViewById(R.id.textDisplay);
// executes the processes made on the fetchData class
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData process = new fetchData();
                process.execute();
            }
        });
    }
//set an intent to take you to the next screen which was the sorting hat screen.
    private void configureSortingButton(){
        Button sortBtn = (Button) findViewById(R.id.srtBtn);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PupilsActivity.this, sortingHat.class));
            }
        });
    }

    private void configureBackButton(){
        ImageButton backButton = (ImageButton) findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}