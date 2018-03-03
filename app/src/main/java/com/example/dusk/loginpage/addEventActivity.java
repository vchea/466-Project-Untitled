package com.example.dusk.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class addEventActivity extends AppCompatActivity {

    public EventClass event = new EventClass();
    public ArrayList<EventClass> eventList = new ArrayList<EventClass>();

    public String checkFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Intent intent = getIntent();
        eventList = (ArrayList<EventClass>) intent.getSerializableExtra("events");
    }

    public void addEvent (View v) {
        EditText title = findViewById(R.id.title);
        event.setEventTitle(title.getText().toString());

        EditText desc = findViewById(R.id.description);
        event.setDesc(desc.getText().toString());

        EditText hourText = findViewById(R.id.hour);
        String hourString = hourText.getText().toString();
        int hourInt = Integer.parseInt(hourString);
        event.setHour(hourInt);

        EditText minText = findViewById(R.id.minute);
        String minString = minText.getText().toString();
        int minInt = Integer.parseInt(minString);
        event.setMinute(minInt);

        eventList.add(event);

        checkFlag = "addEvent";

        Toast.makeText(getApplicationContext(), "Event Added", Toast.LENGTH_SHORT);

        Intent intent = new Intent(this, MainPage.class);
        intent.putExtra("flag", checkFlag);
        intent.putExtra("eventUpdate", eventList);
        startActivity(intent);
    }
}

