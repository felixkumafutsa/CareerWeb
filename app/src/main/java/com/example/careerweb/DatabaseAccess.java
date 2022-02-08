package com.example.careerweb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.careerweb.DatabaseOpenHelper;
import android.widget.Toast;

public class DatabaseAccess {
    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    private Context context;
    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    public  void open(){
        this.db = openHelper.getWritableDatabase();

    }
    public void close(){
        if (db != null){
            this.db.close();
        }
    }
    public String getUniversities(String shortname){
       c=db.rawQuery("select name from universities where shortname = '"+shortname+"'",new String[]{});
       StringBuffer stringBuffer = new StringBuffer();
       while(c.moveToNext()){
        String universityName = c.getString(0);
        stringBuffer.append(""+universityName);
       }
       return stringBuffer.toString();
    }
    void addUniversity(String title, String author, String pages){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", title);
        cv.put("district", author);
        cv.put("shortname", pages);
        long result = db.insert("universities",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllUniversities(){
        String query = "SELECT * FROM universities";
        SQLiteDatabase db = openHelper.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateUniversityData(String row_id, String title, String author, String pages){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", title);
        cv.put("district", author);
        cv.put("shortname", pages);

        long result = db.update("universities", cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneUniversity(String row_id){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        long result = db.delete("universities", "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllUniversities(){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL("DELETE FROM universities");
    }

    void addCourse(String title, String author, String pages){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", title);
        cv.put("shortname", author);
        cv.put("requirements", pages);
        long result = db.insert("course",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllCourses(){
        String query = "SELECT * FROM course";
        SQLiteDatabase db = openHelper.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateCOurseData(String row_id, String title, String author, String pages){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", title);
        cv.put("shortname", author);
        cv.put("requirements", pages);

        long result = db.update("course", cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneCourse(String row_id){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        long result = db.delete("course", "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllCourses(){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL("DELETE FROM course");
    }

    public Boolean insertData(String name, String email, String password ){
        SQLiteDatabase MyDB = openHelper.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDB.insert("admin", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String name) {
        SQLiteDatabase MyDB = openHelper.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where name = ?", new String[]{name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String name, String password){
        SQLiteDatabase MyDB = openHelper.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from admin where name = ? and password = ?", new String[] {name,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
