// Adapted from https://github.com/jakirseu/Android-Pre-Built-database

package com.example.stratagempicker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetDatabaseCloner {

    private Context context;
    private String DB_NAME;

    public AssetDatabaseCloner(Context context, String database_name) {
        this.context = context;
        this.DB_NAME = database_name;
    }

    public SQLiteDatabase saveDatabase() {
        File dbFile = context.getDatabasePath(DB_NAME);

        if (!dbFile.exists()) {
            try {
                copyDatabase(dbFile);
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    private void copyDatabase(File dbFile) throws IOException {

    }

}