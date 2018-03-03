package com.example.dusk.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/*CREATED BY TRAJON FELTON
* 02/27/18
* Purpose: Model Class of the Database with added methods.*/

/*
* TO DO LIST
 * ADD A VERIFICATION METHOD FOR THE LOGIN PAGE
 * ADD A MODIFICATION METHOD FOR EDIT CONTACT PAGE
 * CHECK SIGN UP PAGE FOR COLUMN DATA INFORMATION
 *
 * **SAVE DATA UNDER A USERNAME FROM TASK ACTIVITIES ON MAIN PAGE**
* */


public class DbHelper extends SQLiteOpenHelper {

    //Constant Names
    private static final String DATABASE_NAME = "OrganizeMyLife.db";
    private static final String USER_TABLE = "user_table";

    private static final String UTCOL1 = "ID";
    private static final String UTCOL2 = "USERNAME";
    private static final String UTCOL3 = "PASSWORD";
    private static final String UTCOL4 = "FIRSTNAME";
    private static final String UTCOL5 = "LASTNAME";
    private static final String UTCOL6 = "PHONE";


    private static final String TASK_TABLE = "TASK";
    private static final String TTCOL1 = "taskName";
    private static final String TTCOL2 = "taskStatus";
    private static final String TTCOL3 = "taskSubmitted";
    private static final String TTCOL4 = "taskCompleted";
    private static final String TTCOL5 = "taskGroup";

    //Constructor
    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    //OnCreate Method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + USER_TABLE + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "USERNAME, " +
                "PASSWORD, " +
                "FIRSTNAME, " +
                "LASTNAME, " +
                "PHONE" +
                ")";
        sqLiteDatabase.execSQL(createTable);
        String createAnother = "CREATE TABLE " + TASK_TABLE + " (" +
                "USERNAME NOT NULL PRIMARY KEY," +
                " taskName NOT NULL, " +
                "taskStatus NOT NULL, " +
                "taskSubmitted, " +
                "taskCompleted, " +
                "taskGroup" +
                ")";
        sqLiteDatabase.execSQL(createAnother);
    }

    //onUpgrade Method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TASK_TABLE);
        onCreate(sqLiteDatabase);
    }

    /*
    * addData Method
    * Purpose: Add data into the database
    * Parameters: Username, Password
    * */
    public boolean addUser(String username, String pwd, String fn, String ln, String phn){
        SQLiteDatabase db = this.getWritableDatabase(); //Use this to edit the table

        //ContentValues is used ot create an object to put into the insert method
        ContentValues contentValues = new ContentValues();
        contentValues.put(UTCOL2,username);
        contentValues.put(UTCOL3, pwd);
        contentValues.put(UTCOL4, fn);
        contentValues.put(UTCOL5, ln);
        contentValues.put(UTCOL6, phn);

        //Insert is a SQL Method, basically puts it into the database
        long result = db.insert(USER_TABLE, null, contentValues);

        //This Checks To See if the data was added correctly
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean verification(String username, String pwd){
        SQLiteDatabase db = this.getReadableDatabase();
        //String Query = String.format("SELECT * FROM %s WHERE %s = \'%s\' AND %s = \'%s\'",USER_TABLE, UTCOL2, username, UTCOL3, pwd);
        String Query = String.format("SELECT * FROM USER_TABLE");
        Cursor result = db.rawQuery(Query,null);
        if(result.getCount() >= 1) {
            while(result.moveToNext()){
                String s = result.getString(1);
                Log.d("Count", s);
            }
            return true;
        }
        else {
            Log.d("Count", String.valueOf(result.getCount()));
            Log.d("Count", username);
            Log.d("Count", pwd);

            return false;
        }
    }
}

