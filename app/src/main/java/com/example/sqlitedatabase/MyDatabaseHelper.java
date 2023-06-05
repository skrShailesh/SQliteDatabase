package com.example.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "Book Library.db";
    public static final int DATABASE_VESION = 1;

    public static final String TABLE_NAME = "my library";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "book title";
    public static final String COLUMN_AUTHOR = "book author";
    public static final String COLUMN_PAGES = "book pages";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VESION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENTATION, " +
                        COLUMN_TITLE + "TEXT, " +
                        COLUMN_AUTHOR + "TEXT, " +
                        COLUMN_PAGES + "INTEGER);";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
