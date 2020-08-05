package com.example.potterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class sortingHat extends AppCompatActivity {
    Button click;
    TextView data;
    ImageView logo;
    TextView defaultText;
    String options[] = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_hat);
        configureBackButton();

        click = (Button) findViewById(R.id.srtBtn);
        data = (TextView) findViewById(R.id.resultText);
        defaultText = (TextView) findViewById(R.id.defaultTxt);
        logo = (ImageView) findViewById(R.id.imageView);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randGen = new Random();
                final int rando = randGen.nextInt(4);
                data.setText(options[rando]);
                defaultText.setText("You belong to:");
               if(options[rando] == "Gryffindor"){
                    logo.setVisibility(View.VISIBLE);
                    logo.setImageResource(R.drawable.gryffindor);
                }
                if(options[rando] == "Ravenclaw"){
                    logo.setVisibility(View.VISIBLE);
                    logo.setImageResource(R.drawable.ravenclaw);
                }
                if(options[rando] == "Hufflepuff"){
                    logo.setVisibility(View.VISIBLE);
                    logo.setImageResource(R.drawable.hufflepuff);
                }
                if(options[rando] == "Slytherin"){
                    logo.setVisibility(View.VISIBLE);
                    logo.setImageResource(R.drawable.slytherin);
                }
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