package com.example.wisata_bali_rizky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "user_wisata.db";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, role TEXT)");

        String sql = "CREATE TABLE user(id integer primary key autoincrement, name text null, password text null, role text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2) {
        db0.execSQL("DROP TABLE IF EXISTS user");
    }

    public boolean insert(String username, String password, String role) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("role", role);
        long result = sqLiteDatabase.insert("user", null, contentValues);
        if(result == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=?", new String[]{username});
        if(cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkLogin(String username, String password, String role) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=? AND role=?", new String[]{username, password, role});
        if(cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
