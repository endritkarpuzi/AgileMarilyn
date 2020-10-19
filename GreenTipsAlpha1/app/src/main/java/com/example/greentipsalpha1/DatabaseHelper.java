package com.example.greentipsalpha1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context mcontext;
    String dbPath;

    public static final String DATABASE_NAME = "GreenTips.db";
    public static final String TABLE_NAME = "greentips_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "CATEGORY";
    public static final String COL3 = "TIP_EN";
    public static final String COL4 = "TIP_SV";
    public static final String COL5 = "TIP_ES";
    public static final String COL6 = "TIP_FR";
    public static final String COL7 = "TIP_AR";
    public static final String COL8 = "TIP_SY";
    public static final String COL9 = "TIP_PO";
    public static final String COL10 = "TIP_AL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.mcontext = context;

        this.dbPath = "/data/data/" + "com.example.greentipsalpha1" + "/databases/";
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY, " +
                "CATEGORY TEXT, " +
                "TIP_EN TEXT, " +
                "TIP_SV TEXT, " +
                "TIP_ES TEXT, " +
                "TIP_FR TEXT, " +
                "TIP_AR TEXT, " +
                "TIP_SY TEXT, " +
                "TIP_PO TEXT, " +
                "TIP_AL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String id, String category, String tip, String lan){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, category);

        if(lan == "Engelska") {
            contentValues.put(COL3, tip);
        }
        if(lan == "Svenska") {
            contentValues.put(COL4, tip);
        }
        if(lan == "Spanska") {
            contentValues.put(COL5, tip);
        }
        if(lan == "Franska") {
            contentValues.put(COL6, tip);
        }
        if(lan == "Arabiska") {
            contentValues.put(COL7, tip);
        }
        if(lan == "Syrianska") {
            contentValues.put(COL8, tip);
        }
        if(lan == "Polska") {
            contentValues.put(COL9, tip);
        }
        if(lan == "Albanska") {
            contentValues.put(COL10, tip);
        }

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase dB = this.getWritableDatabase();
        Cursor res = dB.rawQuery("SELECT *FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String category, String tip, String lan){
        SQLiteDatabase dB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, category);

        if(lan == "Engelska") {
            contentValues.put(COL3, tip);
        }
        if(lan == "Svenska") {
            contentValues.put(COL4, tip);
        }
        if(lan == "Spanska") {
            contentValues.put(COL5, tip);
        }
        if(lan == "Franska") {
            contentValues.put(COL6, tip);
        }
        if(lan == "Arabiska") {
            contentValues.put(COL7, tip);
        }
        if(lan == "Syrianska") {
            contentValues.put(COL8, tip);
        }
        if(lan == "Polska") {
            contentValues.put(COL9, tip);
        }
        if(lan == "Albanska") {
            contentValues.put(COL10, tip);
        }

        dB.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Cursor getTip(String iD, String lan){
        SQLiteDatabase dB = this.getWritableDatabase();

        String query = null;
        Cursor tip;
        int id = Integer.parseInt(iD);
        int column = 0;

        if(lan == "Engelska") {
            query = "SELECT " + COL3 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 2;
        }
        if(lan == "Svenska") {
            query = "SELECT " + COL4 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 3;
        }
        if(lan == "Spanska") {
            query = "SELECT " + COL5 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 4;
        }
        if(lan == "Franska") {
            query = "SELECT " + COL6 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 5;
        }
        if(lan == "Arabiska") {
            query = "SELECT " + COL7 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 6;
        }
        if(lan == "Syrianska") {
            query = "SELECT " + COL8 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 7;
        }
        if(lan == "Polska") {
            query = "SELECT " + COL9 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 8;
        }
        if(lan == "Albanska") {
            query = "SELECT " + COL10 + " FROM " + TABLE_NAME + " WHERE ID = " + id;
            column = 9;
        }

        Cursor cursor = dB.rawQuery(query, null);

        if (cursor.moveToFirst()){
            tip = cursor;
        } else {

            tip = null;
        }
        cursor.close();
        dB.close();
        return tip;
    }

    public void CheckDb(){
        SQLiteDatabase checkDb = null;
        String filePath = dbPath + DATABASE_NAME;

        try{
            checkDb = SQLiteDatabase.openDatabase(filePath, null, 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(checkDb != null){
            Toast.makeText(mcontext, "Database already exists", Toast.LENGTH_SHORT).show();
        } else {
            CopyDatabase();
        }
    }

    public void CopyDatabase(){
        this.getReadableDatabase();

        try {
            InputStream ios = mcontext.getAssets().open(DATABASE_NAME);
            OutputStream os = new FileOutputStream(dbPath + DATABASE_NAME);

            byte[] buffer = new byte[1024];

            int len;
            while ((len = ios.read(buffer)) > 0){
                os.write(buffer, 0, len);

            }
            os.flush();
            ios.close();
            os.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        Log.d("CopyDb", "Database copied");
    }

    public void OpenDatabase(){
        String filePath = dbPath + DATABASE_NAME;

        SQLiteDatabase.openDatabase(filePath, null, 0);
    }
}
