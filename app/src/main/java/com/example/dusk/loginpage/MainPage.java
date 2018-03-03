package com.example.dusk.loginpage;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<CardsJava> exampleList = new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public boolean listOld;
    public ArrayList<EventClass> eventList = new ArrayList<EventClass>();
    public String check = "";
    public String add = "addEvent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            check = intent.getString("flag");
            if (check.equals(add)) {
                eventList = (ArrayList<EventClass>) intent.getSerializable("eventUpdate");
                //exampleList.add(new CardsJava(eventList.get(0).getEventTitle(), Integer.toString(eventList.size()), Integer.toString(eventList.get(0).getMin())));
                listOld = true;
            }
            else {
                exampleList.add(new CardsJava("No Tasks", "", ""));
                listOld = false;
            }
        }

        if (listOld) {
            for (int i = 0; i < eventList.size(); i++)
            {
                String titleTemp = eventList.get(i).getEventTitle();
                int hourTemp = eventList.get(i).getHour();
                int minTemp = eventList.get(i).getMin();
                exampleList.add(new CardsJava(titleTemp, Integer.toString(hourTemp), new DecimalFormat("00").format(minTemp)));
            }
        }

        buildRecyclerView();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.addItem) {
            Intent intent = new Intent(this, addEventActivity.class);
            intent.putExtra("check", check);
            intent.putExtra("events", eventList);
            startActivity(intent);
        }
        if (id == R.id.logout){
            Intent intent = new Intent(this, LoginPage.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Adapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}