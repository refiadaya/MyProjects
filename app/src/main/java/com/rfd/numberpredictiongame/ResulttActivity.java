package com.rfd.numberpredictiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResulttActivity extends AppCompatActivity {
    private ImageView imageViewResult2;
    private TextView textViewResult2, textViewTry;
    private Button buttonPlayAgain2;

    private Boolean result;
    private int tryTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultt);
        textViewTry = findViewById(R.id.textViewTry);
        imageViewResult2 = findViewById(R.id.imageViewResult2);
        textViewResult2 = findViewById(R.id.textViewResult2);
        buttonPlayAgain2 = findViewById(R.id.buttonPlayAgain2);

        result = getIntent().getBooleanExtra("result", false);
        tryTime = getIntent().getIntExtra("try", 0);

        if (result){
            textViewTry.setText(tryTime + " denemede");
            textViewResult2.setText("KAZANDINIZ");
            imageViewResult2.setImageResource(R.drawable.mood_happy_image);
        }
        else{
            textViewResult2.setText("KAYBETTİNİZ");
            imageViewResult2.setImageResource(R.drawable.mood_bad_image);
        }

        buttonPlayAgain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResulttActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}