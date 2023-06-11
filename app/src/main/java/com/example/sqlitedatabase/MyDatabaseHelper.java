package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Key;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Book Library.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my library";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "book title";
    private static final String COLUMN_AUTHOR = "book author";
    private static final String COLUMN_PAGES = "book pages";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TITLE + "TEXT," + COLUMN_AUTHOR + "TEXT," + COLUMN_PAGES + "TEXT," + ")");
        

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBook(String title, String author, Integer pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR,author);
        cv.put(COLUMN_PAGES,pages);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successful", Toast.LENGTH_SHORT).show();
        }


    }
}
