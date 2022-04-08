package com.example.careerweb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class UniversityProfile extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    DatabaseAccess myDB;
    ArrayList<String> faculty_id, faculty_name, university_name;
    FacultyAdapter facultyAdapter;
    Button queryButton;
    EditText name;
    TextView result_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_profile);

        result_text = findViewById(R.id.resultName);

        recyclerView = findViewById(R.id.recyclerFaculties);
        /*add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Universities.this, Register.class);
                startActivity(intent);
            }
        });*/


        myDB = new DatabaseAccess(UniversityProfile.this);
        faculty_id = new ArrayList<>();
        faculty_name = new ArrayList<>();
        university_name = new ArrayList<>();

        storeDataInArrays();

        facultyAdapter = new FacultyAdapter(UniversityProfile.this,this, faculty_id, faculty_name, university_name);
        recyclerView.setAdapter(facultyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(UniversityProfile.this));

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllCourses();
        if(cursor.getCount() == 0){
            //empty_imageview.setVisibility(View.VISIBLE);
            // no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                faculty_id.add(cursor.getString(0));
                university_name.add(cursor.getString(1));
                faculty_name.add(cursor.getString(2));
            }
            // empty_imageview.setVisibility(View.GONE);
            //no_data.setVisibility(View.GONE);
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }*/

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseAccess myDB = new DatabaseAccess(UniversityProfile.this);
                myDB.deleteAllCourses();
                //Refresh Activity
                Intent intent = new Intent(UniversityProfile.this, Programs.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}