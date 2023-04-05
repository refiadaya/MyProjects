package com.rfd.numberpredictiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class PredictionActivity extends AppCompatActivity {
    private TextView textViewHelp, textViewChance;
    private EditText editTextNumber;
    private Button buttonGuess;
    private int randomNumber;
    private int counter = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        textViewHelp = findViewById(R.id.textViewHelp);
        textViewChance = findViewById(R.id.textViewChance);
        editTextNumber = findViewById(R.id.editTextNumber);
        buttonGuess = findViewById(R.id.buttonGuess);

        Random r = new Random();
        randomNumber = r.nextInt(101);
        Log.e("random number", String.valueOf(randomNumber));

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                int guess = Integer.parseInt(editTextNumber.getText().toString());

                if (guess==randomNumber){
                    Intent intent = new Intent(PredictionActivity.this, ResulttActivity.class);
                    intent.putExtra("result", true);
                    intent.putExtra("try", 7-counter);
                    startActivity(intent);
                    finish();
                    return; //not to keep going with other ifs
                }

                if (guess>randomNumber){
                    textViewHelp.setText("Tahmini azalt");
                    textViewChance.setText("Kalan hak: " + counter);
                }

                if (guess<randomNumber){
                    textViewHelp.setText("Tahmini artır");
                    textViewChance.setText("Kalan hak: " + counter);
                }

                if (counter==0){
                    Intent intent = new Intent(PredictionActivity.this, ResulttActivity.class);
                    intent.putExtra("result", false);
                    startActivity(intent);
                    finish();
                    return;
                }
                editTextNumber.setText("");

            }
        });
    }
}