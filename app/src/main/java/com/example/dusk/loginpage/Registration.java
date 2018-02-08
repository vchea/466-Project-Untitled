package com.example.dusk.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*
* Register Class will need the following changes on a later tie
*  - Add Variables for all required columns of the SQL database
*  - function to check all inputed variables match the minimum
*  maximum length of the SQL Database
*  - UI improvement and functionality
*  - Method for pause, stop states in the android lifecycle
*  Made on 02/08/18 By Trajon Felton
* */
public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
}
