package com.example.careerweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    Button eligibiityButton, mentorship, login;
    ImageButton universities, programs, faq, all_mentors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        eligibiityButton = findViewById(R.id.eligibility);
        mentorship = findViewById(R.id.mentorship);
        universities = findViewById(R.id.imageV13iew);
        all_mentors = findViewById(R.id.imageView1d3);
        programs = findViewById(R.id.imagew13Vie);
        faq = findViewById(R.id.imageViews13);

        eligibiityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, EligibilityCheck.class));
            }
        });

        mentorship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, RegisterMentor.class));
            }
        });
        all_mentors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Mentors.class));
            }
        });

        universities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Universities.class));
            }
        });
        programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Programs.class));
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Faq.class));
            }
        });
    }

    public void toLogin(View view) {
        startActivity(new Intent(Home.this, Login.class));
    }
}