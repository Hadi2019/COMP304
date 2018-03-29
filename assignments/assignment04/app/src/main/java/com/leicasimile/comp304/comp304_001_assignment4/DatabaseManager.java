package com.leicasimile.comp304.comp304_001_assignment4;

import java.util.ArrayList; 
import java.util.List; 
  
import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
  
public class DatabaseManager extends SQLiteOpenHelper { 

	private static final String DATABASE_NAME = "StudentRecruitment.db";
    private static final int DATABASE_VERSION = 1;

    private String tables[];
    private String tableCreatorString[]; // SQL statements to create tables

    public DatabaseManager(Context context) { 
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Initialize database table names and DDL statements
    public void dbInitialize(String[] tables, String tableCreatorString[])
    {
  	    this.tables = tables;
  	    this.tableCreatorString = tableCreatorString;
    }
  
    // Create tables 
    @Override
    public void onCreate(SQLiteDatabase db) {
    	for (int i = 0; i < tables.length; i++)
    		db.execSQL("DROP TABLE IF EXISTS " + tables[i]);

    	for (int i = 0; i < tableCreatorString.length; i++)
    		db.execSQL(tableCreatorString[i]);
    } 

    public void createDatabase(Context context)
    {
    	SQLiteDatabase mDatabase;
    	mDatabase = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,
                null);
    }

    public void deleteDatabase(Context context)
    {
    	context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
        // Drop existing tables
    	for (int i = 0; i < tables.length; i++)
    		db.execSQL("DROP TABLE IF EXISTS " + tables[i]);
                 
        // Create tables again 
        onCreate(db); 
    }

    // -- Database operations -- //
    void addRecord(ContentValues values, String tableName, String fields[],String record[]) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
  
        for (int i = 1; i < record.length; i++)
        	values.put(fields[i], record[i]);

        db.insert(tableName, null, values); 
        db.close();
    }
    
    // Read all records 
    public List getTable(String tableName) { 
        List table = new ArrayList();
        String selectQuery = "SELECT  * FROM " + tableName; 
  
        SQLiteDatabase db = this.getReadableDatabase(); 
        Cursor cursor = db.rawQuery(selectQuery, null); 
        ArrayList row = new ArrayList(); //to store one row

        //scroll over rows and store each row in an array list object
        if (cursor.moveToFirst()) 
        { 
        	do 
        	{
        		for (int i = 0; i < cursor.getColumnCount(); i++) {
        			row.add(cursor.getString(i));
        		}
            
                table.add(row);
                
            } while (cursor.moveToNext()); 
        } 
  
        // return table as a list 
        return table; 
    } 

    public int updateRecord(ContentValues values, String tableName, String fields[],String record[]) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
  
        for (int i = 1; i < record.length; i++)
        	values.put(fields[i], record[i]);
  
        // updating row with given id = record[0]
        return db.update(tableName, values, fields[0] + " = ?", 
                new String[] { record[0] }); 
    } 

    public void deleteRecord(String tableName, String idName, String id) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
        db.delete(tableName, idName + " = ?", 
                new String[] { id }); 
        db.close(); 
    }
} 
