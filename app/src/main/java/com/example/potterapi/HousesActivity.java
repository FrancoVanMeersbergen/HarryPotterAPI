package com.example.potterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HousesActivity extends AppCompatActivity {
    Button click;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);

        configureBackButton();

        click = findViewById(R.id.fetchDataBtn);
        data = (TextView) findViewById(R.id.textDisplay);
// executes the processes made on the fetchHouses class
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchHouses process = new fetchHouses();
                process.execute();
            }
        });
    }
// allows the back button to take you back to the main menu
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