package com.example.dusk.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


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
    private static final String TABLE_NAME = "user_table";
    private static final String[] COL = {"ID", "USERNAME", "PASSWORD"};

    //Constructor
    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    //OnCreate Method
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE" + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT. " +
                " USERNAME TEXT, PASSWORD TEXT";
        sqLiteDatabase.execSQL(createTable);
    }

    //onUpgrade Method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    /*
    * addData Method
    * Purpose: Add data into the database
    * Parameters: Username, Password
    * */
    public boolean addData(String username, String pwd){
        SQLiteDatabase db = this.getWritableDatabase(); //Use this to edit the table

        //ContentValues is used ot create an object to put into the insert method
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL[2], username);
        contentValues.put(COL[3], pwd);

        //Insert is a SQL Method, basically puts it into the database
        long result = db.insert(TABLE_NAME, null, contentValues);

        //This Checks To See if the data was added correctly
        if(result == -1)
            return false;
        else
            return true;
    }
}

