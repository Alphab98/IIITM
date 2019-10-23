package com.example.iiitmstars;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.iiitmstars.ui.aboutiiitm.AboutIIITMFragment;
import com.example.iiitmstars.ui.academics.AcademicsFragment;
import com.example.iiitmstars.ui.contactus.ContactUsFragment;
import com.example.iiitmstars.ui.department.DepartmentFragment;
import com.example.iiitmstars.ui.info.InfoFragment;
import com.example.iiitmstars.ui.people.PeopleActivity;
import com.example.iiitmstars.ui.tnp.TnpFragment;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private SliderView sliderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sliderView = findViewById(R.id.imageSlider);

        SliderAdapterExample adapter = new SliderAdapterExample(this);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();



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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;
        CardView cardView = findViewById(R.id.slide_show);

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_aboutiiitm:
                cardView.setVisibility(View.INVISIBLE);
                fragment = new AboutIIITMFragment();
                break;
            case R.id.nav_academics:
                cardView.setVisibility(View.INVISIBLE);
                fragment = new AcademicsFragment();
                break;
            case R.id.nav_contactus:
                cardView.setVisibility(View.INVISIBLE);
                fragment = new ContactUsFragment();
                break;
            case R.id.nav_department:
                cardView.setVisibility(View.INVISIBLE);
                fragment = new DepartmentFragment();
                break;
            case R.id.nav_info:
                cardView.setVisibility(View.INVISIBLE);
                fragment = new InfoFragment();
                break;
            case R.id.nav_people:

                Intent intent = new Intent(this, PeopleActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_tnp:
                cardView.setVisibility(View.INVISIBLE);
                fragment = new TnpFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }


}
