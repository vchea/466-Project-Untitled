package com.example.dusk.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info_page);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);


    //Object Variables
    EditText username = (EditText) findViewById(R.id.nameText);
    EditText password = (EditText) findViewById(R.id.passwordText);
    EditText newPassword = (EditText) findViewById(R.id.newPasswordText);
    EditText email = (EditText) findViewById(R.id.emailText);
    EditText phone = (EditText) findViewById(R.id.phoneText);

    Button btnCancel = (Button) findViewById(R.id.cancelButton);
    Button btnSave = (Button) findViewById(R.id.saveButton);




}
