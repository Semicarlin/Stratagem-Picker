// Adapted from https://stackoverflow.com/a/47166775

package com.example.stratagempicker.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.stratagempicker.Activities.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Interfaces with .db file within app data and handles read/write operations to database
 */
public class Database extends SQLiteOpenHelper {

    // Attributes
    private final String dbName;
    private final String appDataPath;
    private final String userPreferencesTableName = "user_preferences";
    private List<Stratagem> allStratagems = new ArrayList<>();
    private final Random randomGenerator = new Random();
    private SQLiteDatabase sqLiteDatabase;

    // Constructor
    public Database(Context context, String dbName) {
        super(context, dbName, null, 1);
        this.dbName = dbName;
        this.appDataPath = context.getApplicationInfo().dataDir;

        // Create or open database from device files
        sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(appDataPath + "/databases/" + dbName, null);

        // Get contents of database
        getDatabaseContents();
    }

    // Functions
    private void getDatabaseContents() {

        // Get stratagems
        PrePopulation prePop = new PrePopulation();
        allStratagems = Arrays.asList(prePop.getStratagems());

        // Check for user preferences table
        if (!tableExists(userPreferencesTableName)) {
            createUserPreferencesTable();
        }
        readUserPreferencesTable();

        // Read categories table
        // TODO

        // Read isOwned table
        // TODO
    }

    private boolean tableExists(String tableName) {

        // Write query to check for table
        String query = "SELECT DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "';";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor != null) {
            int results = cursor.getCount();
            cursor.close();
            return results > 0;
        }
        return false;
    }

    private void readUserPreferencesTable() {
        Log.d("USERTABLE", "EXISTS");

        // Get user preferences from database "user_preferences(id INTEGER PRIMARY KEY, allowMutlipleWeapons INTEGER, allowMultipleBackpacks INTEGER, allowMultipleEagles INTEGER);
        String userQuery = "SELECT * FROM " + userPreferencesTableName + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(userQuery, null);
        if (cursor.moveToFirst()) {

            // Get attributes of user
            int id = cursor.getInt(0);
            boolean allowMultipleWeapons = cursor.getInt(1) == 1;
            boolean allowMultipleBackpacks = cursor.getInt(2) == 1;
            boolean allowMultipleEagles = cursor.getInt(3) == 1;

            // Update user object
            MainActivity.user.updateUser(allowMultipleWeapons, allowMultipleBackpacks, allowMultipleEagles);

        }

        // Close cursor
        cursor.close();
    }

    private void createUserPreferencesTable() {
        Log.d("USERTABLE", "DOES NOT EXISTS");

        // Write table into db
        String createIfNotExistQuery = "CREATE TABLE IF NOT EXISTS " + userPreferencesTableName +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "allowMutlipleWeapons INTEGER, " +
                "allowMultipleBackpacks INTEGER, " +
                "allowMultipleEagles INTEGER);";
        sqLiteDatabase.execSQL(createIfNotExistQuery);

        // Write user table to default construction
        String writeUserRow = "INSERT INTO " + userPreferencesTableName + " VALUES (0, "
                + (MainActivity.user.isAllowMultipleWeapons() ? 1 : 0) +", "
                + (MainActivity.user.isAllowMultipleBackpacks() ? 1 : 0) + ", "
                + (MainActivity.user.isAllowMultipleEagles() ? 1 : 0) + ");";
        sqLiteDatabase.execSQL(writeUserRow);
    }

    public Stratagem getRandomStratagem() {
        return allStratagems.get(randomGenerator.nextInt(allStratagems.size()));
    }

    public Batch makeBatch() {
        Batch batch = new Batch();
        for (int i = 0; i < 4; ++i) {
            while (!batch.tryToAdd(getRandomStratagem())) {
                continue;
            }
        }
        return batch;
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

    private void writeDatabaseFromAssets(Context context, File dbFile) {
        // Adapted from https://github.com/jakirseu/Android-Pre-Built-database
        try {
            // Open file input/output streams
            InputStream is = context.getAssets().open(dbName);
            OutputStream os = new FileOutputStream(dbFile);

            // Write to file
            byte[] buffer = new byte[1024];
            while (is.read(buffer) > 0) {
                os.write(buffer);
            }

            // Flush buffer in close streams
            os.flush();
            os.close();
            is.close();
        }
        catch (IOException e) {
            throw new RuntimeException("Error creating source database", e);
        }
    }
}
