package com.example.blood_bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Features extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private Button status_id,next_donation_id,facts_id;
    private ImageView search_id,status_id,next_donation_id,facts_id;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Menu menu = navigationView.getMenu();
//        menu.findItem(R.id.nav_logout).setVisible(false);
//        menu.findItem(R.id.nav_profile).setVisible(false);
          status_id=(ImageView) findViewById(R.id.status_id);
        search_id=(ImageView) findViewById(R.id.search_id);
        next_donation_id=(ImageView)findViewById(R.id.next_donation_id);
        facts_id=(ImageView)findViewById(R.id.facts_id);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Features.this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(Features.this);
        navigationView.setCheckedItem(R.id.nav_home);



        status_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open_status();

            }
        });

        search_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            open_search();

            }
        });

        next_donation_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        facts_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }



    public void open_status(){

        Intent intent = new Intent(Features.this, Status_feed.class);

        startActivity(intent);


    }

    public void open_search(){

        Intent intent = new Intent(Features.this, Search.class);

        startActivity(intent);

    }
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_bus:
                Intent intent = new Intent(Features.this,add_ambulance.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Intent intent2 = new Intent(Features.this,Login.class);
                startActivity(intent2);
                break;
            case R.id.nav_ambulance:
                Intent intent3 = new Intent(Features.this,show_ambulance.class);
                startActivity(intent3);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }
}