package com.example.vinay.mydata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyData extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;
    private static String tableName;
    private static String tableCreatorString;

    public MyData(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreatorString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    public void dbInitialize(String tableName, String tableCreatorString)
    {
        this.tableName=tableName;
        this.tableCreatorString=tableCreatorString;
    }

    // CRUD Operations

    public boolean addRow(ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        long nr= db.insert(tableName,null, values);
        db.close();
        return nr > -1;
    }

    public Student getStudentById(Integer id, String fieldName) throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from " + tableName + " where "+ fieldName + "='"+ id +"'", null );
        Student student = new Student();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setId(cursor.getInt(0));
            student.setSname(cursor.getString(1));
            student.setCname(cursor.getString(2));
            cursor.close();

        } else {
            student = null;
        }
        db.close();
        return student;

    }

    
}
