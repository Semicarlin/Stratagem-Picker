// Adapted from https://stackoverflow.com/a/47166775

package com.example.stratagempicker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseHelper extends SQLiteOpenHelper {

    private String dbName;
    private String appDataPath;
    private Context context;
    SQLiteDatabase database;


    public DatabaseHelper(Context context, String dbName) {
        super(context, dbName, null, 1);
        this.dbName = dbName;
        this.context = context;
        this.appDataPath = context.getApplicationInfo().dataDir;
    }

    public boolean openDatabase() {
        String mPath = appDataPath + "/databases/" + dbName;
        database = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READWRITE);
        return database != null;
    }

    // Called the first time the database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Do nothing as db already exists and is static
    }

    // Called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do nothing as db already exists and is static
    }

}
