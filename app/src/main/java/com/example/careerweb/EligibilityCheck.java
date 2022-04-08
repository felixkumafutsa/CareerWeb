package com.example.careerweb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EligibilityCheck extends AppCompatActivity {
    EditText english_score,maths_score, bio_score, chemistry_score, physics_score, agriculture_score, chich_score, geog_score, social_score, hist_score, bk_score;
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
        chich_score = findViewById(R.id.chichewa);
        geog_score = findViewById(R.id.geog);
        social_score = findViewById(R.id.social);
        hist_score = findViewById(R.id.history);
        bk_score = findViewById(R.id.bk);
        checkBtn = findViewById(R.id.checkBtn);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEligibility();

            }
        });

    }

    private void checkEligibility() {

        int en,mat,bio,chem, phy,agr, chich, geog, his, social, bk;
        chich= Integer.parseInt(chich_score.getText().toString());
        geog= Integer.parseInt(geog_score.getText().toString());
        his= Integer.parseInt(hist_score.getText().toString());
        social= Integer.parseInt(social_score.getText().toString());
        bk= Integer.parseInt(bk_score.getText().toString());
        en = Integer.parseInt(english_score.getText().toString());
        mat = Integer.parseInt(maths_score.getText().toString());
        bio = Integer.parseInt(bio_score.getText().toString());
        chem = Integer.parseInt(chemistry_score.getText().toString());
        phy = Integer.parseInt(physics_score.getText().toString());
        agr = Integer.parseInt(agriculture_score.getText().toString());
        int aggregateSciencesScore = en + mat + bio + chem + phy + agr;
        int aggregateHumanitiesScore = chich + geog + his + social + bk;

        if(en > 0 && en < 6){
            if (aggregateSciencesScore < aggregateHumanitiesScore ){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eligibility Results");
                builder.setMessage("You are legible to be admitted into  Science programs tap proceed" +
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
            }else if(aggregateSciencesScore > aggregateHumanitiesScore ){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eligibility Results");
                builder.setMessage("You are legible to be admitted into non-Science programs tap proceed" +
                        " to view recommended programs or cancel to go to homepage");
                builder.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(EligibilityCheck.this, Programs.class);
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
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eligibility Results");
                builder.setMessage("Sorry we are unable to match your score with any program proceed" +
                        " to view matching programs or cancel to go to homepage");
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
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Eligibility Results");
            builder.setMessage("You are not legible to be admitted into a University program tap proceed" +
                    " to view recommended programs or cancel to go to homepage");
            builder.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(EligibilityCheck.this, Home.class);
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
}