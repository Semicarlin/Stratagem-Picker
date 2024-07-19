package com.example.stratagempicker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String STRATAGEM_TABLE = "stratagems";
    public static final String COL_STRATAGEM_ID = "id";
    public static final String COL_STRATAGEM_NAME = "name";
    public static final String COL_STRATAGEM_INPUT = "input";
    public static final String COL_STRATAGEM_CALL_IN_TIME = "callInTime";
    public static final String COL_STRATAGEM_USES = "uses";
    public static final String COL_STRATAGEM_COOLDOWN = "cooldown";
    public static final String COL_STRATAGEM_IS_OWNED = "owned";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "sp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + STRATAGEM_TABLE +
                "(" + COL_STRATAGEM_ID + " INT PRIMARY KEY AUTOINCREMENT, " +
                COL_STRATAGEM_NAME + " CHAR, " +
                COL_STRATAGEM_INPUT + " CHAR, " +
                COL_STRATAGEM_CALL_IN_TIME + " INT, " +
                COL_STRATAGEM_USES + " REAL, " +
                COL_STRATAGEM_COOLDOWN + " INT," +
                COL_STRATAGEM_IS_OWNED + " INT);";
        db.execSQL(createTableStatement);
    }

    private void prePopulateDatabase(SQLiteDatabase db) {
        db.execSQL();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
