package com.leicasimile.comp304.comp304_001_assignment4;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {
    private static DatabaseManager sInstance;

	private static final String DATABASE_NAME = "StudentRecruitment.db";
    private static final int DATABASE_VERSION = 1;

    private String tables[];
    private String tableCreatorString[]; // SQL statements to create tables

    // Use this instead of the constructor to access the database
    public static synchronized DatabaseManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Initialize database table names and DDL statements
    public void dbInitialize(String[] tables, String tableCreatorString[]) {
  	    this.tables = tables;
  	    this.tableCreatorString = tableCreatorString;
    }
  
    // Create tables 
    @Override
    public void onCreate(SQLiteDatabase db) {
    	for (int i = 0; i < tables.length; i++) {
            db.execSQL("DROP TABLE IF EXISTS " + tables[i]);
        }

    	for (int i = 0; i < tableCreatorString.length; i++) {
            db.execSQL(tableCreatorString[i]);
        }
        insertInitialRecords(db);
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

    private String sanitize(String s) {
        return s.replaceAll("[^\\w_]", "");
    }

    // -- Database operations -- //
    private void insertInitialRecords(SQLiteDatabase db) {
        String[][] studentRecords = {
                {"beep", "boop", "Beep", "Boop", "40 Street St", "Toronto", "M5J 2M3"}
        };
        String[][] adminRecords = {
                {"boop", "beep", "Boop", "Beep"}
        };
        Object[][] programRecords = {
                {"3409", "Software Engineering Technology", 2935.50, 3, 6},
                {"6409", "Art and Design Fundamentals", 2935.50, 1, 2},
                {"6423", "Animation 3D", 6436.50, 2, 4}
        };

        for (int i = 0; i < studentRecords.length; i++) {
            addRecord("Student", studentRecords[i], db);
        }

        for (int i = 0; i < adminRecords.length; i++) {
            addRecord("Admin", adminRecords[i], db);
        }

        for (int i = 0; i < programRecords.length; i++) {
            addRecord("Program", programRecords[i], db);
        }
    }

    private void addRecord(String table, Object[] values, SQLiteDatabase db) {
        List<String> columns;
        switch (table) {
            case "Student":
                columns = Arrays.asList("username", "password", "firstname", "lastname", "address", "city", "postalCode");
                break;
            case "Admin":
                columns = Arrays.asList("username", "password", "firstname", "lastname");
                break;
            case "Program":
                columns = Arrays.asList("programCode", "programName", "tuitionFee", "duration", "semester");
                break;
            case "Payment":
                columns = Arrays.asList("studentId", "programCode", "totalAmount", "amountPaid",
                        "balance", "paymentDate", "status");
                break;
            default:
                throw new InvalidParameterException("Invalid table name: " + table);
        }

        if (columns.size() != values.length) {
            throw new InvalidParameterException(String.format("Number of columns must be equal to number of values" +
                    "(table: %s, columns: %d, values: %d)", table, columns.size(), values.length));
        }

        ContentValues cv = new ContentValues();

        for (int i = 0; i < columns.size(); i++) {
            String column = columns.get(i);
            switch (column) {
                case "tuitionFee":
                case "totalAmount":
                case "amountPaid":
                case "balance":
                    cv.put(column, (double)values[i]);
                    break;
                case "duration":
                case "semester":
                case "paymentDate":
                    cv.put(column, (int)values[i]);
                    break;
                default:
                    cv.put(column, values[i].toString());
                    break;
            }
        }
        db.insert(table, null, cv);
    }

    // Read all records 
    public List getTable(String tableName) {
        List table = new ArrayList();
        String selectQuery = "SELECT  * FROM " + sanitize(tableName);
  
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

    public String getField(String table, String column, String constraintColumn, String constraintValue) {
        table = sanitize(table);
        column = sanitize(column);
        constraintColumn = sanitize(constraintColumn);

        String selectQuery = String.format("SELECT %s FROM %s WHERE %s=? LIMIT 1", column, table, constraintColumn);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[] {constraintValue});

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(column));
        }

        return "";
    }

    public void addRecord(String table, Object[] values) {
        List<String> columns;
        switch (table) {
            case "Student":
                columns = Arrays.asList("username", "password", "firstname", "lastname", "address", "city", "postalCode");
                break;
            case "Admin":
                columns = Arrays.asList("username", "password", "firstname", "lastname");
                break;
            case "Program":
                columns = Arrays.asList("programCode", "programName", "tuitionFee", "duration", "semester");
                break;
            case "Payment":
                columns = Arrays.asList("studentId", "programCode", "totalAmount", "amountPaid",
                        "balance", "paymentDate", "status");
                break;
            default:
                throw new InvalidParameterException("Invalid table name: " + table);
        }

        if (columns.size() != values.length) {
            throw new InvalidParameterException("Number of columns must be equal to the number of values");
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        try {
            for (int i = 0; i < columns.size(); i++) {
                String column = columns.get(i);
                switch (column) {
                    case "tuitionFee":
                    case "totalAmount":
                    case "amountPaid":
                    case "balance":
                        cv.put(column, (double)values[i]);
                        break;
                    case "duration":
                    case "semester":
                    case "paymentDate":
                        cv.put(column, (int)values[i]);
                        break;
                    default:
                        cv.put(column, values[i].toString());
                        break;
                }
            }
            db.insert(table, null, cv);
        } finally {
            db.close();
        }
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
