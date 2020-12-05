package com.example.branoidass.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="BookDta.db";
    public static final String TABLE1="Menu_Table";
    public static final String TABLE2="AllBook_Table";
    public static final String TABLE3="Announcements_Table";
    public static final String TABLE4="Announcements_Details_Table";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String statement1= "create table " + TABLE1 + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,image TEXT,image_caption TEXT)";

        String statement2= "create table " + TABLE2 + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,book_name TEXT,book_image TEXT,subtitle TEXT,full_book_image TEXT)";

        String statement3= "create table " + TABLE3 + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,image TEXT,image_caption TEXT,created_date,last_updated)";

        String statement4= "create table " + TABLE3 + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,image TEXT,image_caption TEXT,created_date,last_updated)";


        sqLiteDatabase.execSQL(statement1);

        sqLiteDatabase.execSQL(statement2);

        sqLiteDatabase.execSQL(statement3);

        sqLiteDatabase.execSQL(statement3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
