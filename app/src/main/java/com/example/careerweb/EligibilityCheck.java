package com.example.careerweb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class EligibilityCheck extends AppCompatActivity {
    EditText english_score,maths_score, bio_score, chemistry_score, physics_score, agriculture_score;
    Button checkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility_check);

        english_score = findViewById(R.id.eng);
        maths_score = findViewById(R.id.maths);
        bio_score = findViewById(R.id.bio);
        chemistry_score = findViewById(R.id.chemi);
        physics_score = findViewById(R.id.phy);
        agriculture_score = findViewById(R.id.agri);
        checkBtn = findViewById(R.id.checkBtn);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEligibility();

            }
        });

    }

    private void checkEligibility() {
        int aggregateScore = 0;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eligibility Results");
        builder.setMessage("You are legible to be admitted into a University program tap proceed" +
                " to view recommended programs or cancel to go to homepage");
        builder.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(EligibilityCheck.this, Universities.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}