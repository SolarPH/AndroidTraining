package com.solarph.databaseTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String dbName = "myDatabase";
    private static final int dbVersion = 3;
    private static final String dbTable = "myTable";
    private static final String dbCol_ID = "ID";
    private static final String dbCol_Name = "NAME";
    private static final String dbCol_Password = "PASSWORD";

    private static final String createDB = "CREATE TABLE " + dbTable +
            "(" + dbCol_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            dbCol_Name + " TEXT, " +
            dbCol_Password + " TEXT)";

    public DatabaseManager(Context context)
    {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + dbTable);
        onCreate(sqLiteDatabase);
    }

    public void setData(String name, String pass)
    {
        SQLiteDatabase dbInstance = this.getWritableDatabase();
        ContentValues contents = new ContentValues();

        contents.put(dbCol_Name, name);
        contents.put(dbCol_Password, pass);

        dbInstance.insert(dbTable, null, contents);
        dbInstance.close();
    }

    public String[][] getData()
    {
        SQLiteDatabase dbInstance = this.getReadableDatabase();
        ArrayList<String[]> myList = new ArrayList<>();
        Cursor dbContents = dbInstance.rawQuery("SELECT * FROM " + dbTable, null);
        if (dbContents.moveToFirst())
        {
            do {
                myList.add(new String[]{dbContents.getString(1), dbContents.getString(2)});
            } while (dbContents.moveToNext());
        }
        dbInstance.close();
        return myList.toArray(new String[0][0]);
    }
}
