package com.example.careerweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AdminPage extends AppCompatActivity {
    ImageButton universities, programs, faq, mentors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        universities = findViewById(R.id.imageV13iew);
        programs = findViewById(R.id.imagew13Vie);
        faq = findViewById(R.id.imageViews13);
        mentors = findViewById(R.id.imageView1d3);



        universities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, Universities.class));
            }
        });
        programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, Programs.class));
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, Faq.class));
            }
        });
        mentors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPage.this, Mentors.class));
            }
        });
    }

    public void toAddMentor(View view) {
        startActivity(new Intent(AdminPage.this, RegisterMentor.class));
    }

    public void toAddUniversity(View view) {
        startActivity(new Intent(AdminPage.this, Register.class));
    }

    public void toAddFaq(View view) {
        startActivity(new Intent(AdminPage.this, AddFaq.class));
    }
}