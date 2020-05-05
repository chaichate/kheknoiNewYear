package com.chaiidev.kheknoi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "kheknoi";
    private static final String TABLE_NAME = "visitor";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NAME2 = "message";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME +","+ COLUMN_NAME2 + ")" ;

    private static final String CREATE_UNIQUE_INDEX = "CREATE UNIQUE INDEX IF NOT EXISTS "
            + COLUMN_NAME +  " ON "
            + TABLE_NAME +  "(" + COLUMN_NAME + "," + COLUMN_NAME2  +")" ;

    public DataBaseHelper (Context context ){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_UNIQUE_INDEX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addVister(Visitor category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put(COLUMN_NAME , category.getName() );
        cv.put(COLUMN_NAME2 , category.getMessage() );

        db.insert(TABLE_NAME , null ,cv);
        db.close();
    }

    public int getVisitorCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public List<Visitor> getAllVisitor(){

        List<Visitor> list = new ArrayList<Visitor>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME  , null);
        if(cursor.moveToFirst())
        {
            do {
                Visitor vis = new Visitor(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) , cursor.getString(cursor.getColumnIndex(COLUMN_NAME2))) ;
                list.add(vis);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return list ;
    }


}
