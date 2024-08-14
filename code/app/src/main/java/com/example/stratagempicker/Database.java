// Adapted from https://stackoverflow.com/a/47166775

package com.example.stratagempicker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {

    private DatabaseHelper databaseHelper;
    private final String stratagemTableName = "stratagems";
    private List<Stratagem> stratagemList = new ArrayList<>();
    private Random randomGenerator = new Random();

    public Database(Context context, String dbName) {
        databaseHelper = new DatabaseHelper(context, dbName);
        databaseHelper.openDatabase();
        getDatabaseContents();
    }

    public void getDatabaseContents() {

        // Get all stratagems from database stratagems(id INTEGER PRIMARY KEY, name CHAR, input CHAR, callInTime INTEGER, uses REAL, cooldown INTEGER);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String stratagemQuery = "SELECT * FROM " + stratagemTableName + ";";
        Cursor cursor = db.rawQuery(stratagemQuery, null);
        if (cursor.moveToFirst()) {

            // Iterate through results of query
            do {
                // Get attributes of next stratagem
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                Log.d("Strat", name);
                String input = cursor.getString(2);
                int callInTime = cursor.getInt(3);
                Float uses = cursor.getFloat(4);
                int cooldown = cursor.getInt(5);

                // Make stratagem object and add to list
                Stratagem newStrat = new Stratagem(id, name, input, callInTime, uses, cooldown);
                stratagemList.add(newStrat);

            } while (cursor.moveToNext());


        }
        else {
            // nothing to add to list
        }

        // Close cursor and db
        cursor.close();
        db.close();
    }

    public Stratagem getRandomStratagem() {
        Log.d("mine", Integer.toString(stratagemList.size()));
        return stratagemList.get(randomGenerator.nextInt(stratagemList.size()));
    }
}
