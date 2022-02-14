package com.example.careerweb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddFaq extends AppCompatActivity {
    EditText username,emailAddress;
    Button signup;
    DatabaseAccess DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        emailAddress = (EditText) findViewById(R.id.email);
        signup = (Button) findViewById(R.id.btnsignup);
        DB = new DatabaseAccess(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String email = emailAddress.getText().toString();

                if(user.equals("")|email.equals(""))
                    Toast.makeText(AddFaq.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(!user.equals("")){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertFaqData(user);
                            if(insert==true){
                                Toast.makeText(AddFaq.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(AddFaq.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(AddFaq.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(AddFaq.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

    }


    public void toLogin(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}
