package tech.finaqua.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(getApplicationContext(), CameraActivity.class));
                /*setContentView(R.layout.activity_camera);
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, Camera2BasicFragment.newInstance())
                        .commit();*/


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //TODO : Replace with a Main Fragment.
        ForecastActivity forecast_fragment = new ForecastActivity();
        forecast_fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, forecast_fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_capture) {
            // Handle the camera action
            //Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_profile) {

        } else*/ if (id == R.id.nav_tracking) {
            startActivity(new Intent(getApplicationContext(), TrackActivity.class));
        } else if (id == R.id.nav_map) {
            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
//            MapsActivity map_fragment = new MapsActivity();
//            map_fragment.setArguments(getIntent().getExtras());
//            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, map_fragment).commit();
        } else if (id == R.id.nav_forecast) {
            //startActivity(new Intent(getApplicationContext(), ForecastActivity.class));
            ForecastActivity forecast_fragment = new ForecastActivity();
            forecast_fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, forecast_fragment).commit();
        } else if (id == R.id.nav_education) {
            //startActivity(new Intent(getApplicationContext(), EducationActivity.class));
            EducationActivity education_fragment = new EducationActivity();
            education_fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, education_fragment).commit();
        } else if (id == R.id.nav_community) {

        } else if (id == R.id.nav_red_list) {

        } else if (id == R.id.nav_fishbase) {

        } else if (id == R.id.nav_regulations) {

        } else if (id == R.id.nav_contact) {
            //startActivity(new Intent(getApplicationContext(), ContactActivity.class));
            ContactActivity contact_fragment = new ContactActivity();
            contact_fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, contact_fragment).commit();
        } else if (id == R.id.nav_about) {
            //startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            AboutActivity about_fragment = new AboutActivity();
            about_fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, about_fragment).commit();
        }
        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

