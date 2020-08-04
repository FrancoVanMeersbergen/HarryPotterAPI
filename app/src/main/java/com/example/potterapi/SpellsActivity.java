package com.example.potterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SpellsActivity extends AppCompatActivity {
    Button click;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells);
        configureBackButton();

        click = findViewById(R.id.fetchDataBtn);
        data = (TextView) findViewById(R.id.textDisplay);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchSpells process = new fetchSpells();
                process.execute();
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