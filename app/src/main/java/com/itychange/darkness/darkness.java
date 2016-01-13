package com.itychange.darkness;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import fragment.fragmentdetail;
import fragment.fragmentgifanimater;
import fragment.fragmentgiftabcute;
import fragment.fragmentgiftabrobot;
import fragment.fragmentmain;

public class darkness extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, fragmentmain.OnFragmentClickListener, fragmentgiftabcute.OnFragmentClickListener_tabcute, fragmentgiftabrobot.OnFragmentClickListener_tabrobot {


    public static final Map<String, String> FRAGMENT_TAG = new HashMap<>();

    private TextView txt_connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkness);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txt_connection= (TextView) findViewById(R.id.checkinternet);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        putFragment();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {//fragment main
                finish();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ConnectivityManager conMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ) {
            txt_connection.setVisibility(View.VISIBLE);

        }
        else if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            txt_connection.setVisibility(View.GONE);
            transactionFragment(new fragmentmain());
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String currentFragment = this.getSupportFragmentManager().findFragmentById(R.id.content).getClass().getSimpleName();

        if (id == R.id.nav_natural) {
            if (!fragmentmain.class.getSimpleName().equals(currentFragment)) {
                transactionFragment(new fragmentmain());
            }
        } else if (id == R.id.nav_gif) {
            if (!fragmentgifanimater.class.getSimpleName().equals(currentFragment)) {
                transactionFragment(new fragmentgifanimater());
            }
        } else if (id == R.id.nav_animal) {
            if (!fragmentmain.class.getSimpleName().equals(currentFragment)) {
                transactionFragment(new fragmentmain());
            }
        } else if (id == R.id.nav_manage) {
            if (!fragmentmain.class.getSimpleName().equals(currentFragment)) {
                transactionFragment(new fragmentmain());
            }
        } else if (id == R.id.nav_share) {
            if (!fragmentmain.class.getSimpleName().equals(currentFragment)) {
                transactionFragment(new fragmentmain());
            }
        } else if (id == R.id.nav_send) {
            if (!fragmentmain.class.getSimpleName().equals(currentFragment)) {
                transactionFragment(new fragmentmain());
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void transactionFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    private void putFragment() {
        FRAGMENT_TAG.put(fragmentmain.class.getSimpleName(), "fragment main");
        FRAGMENT_TAG.put(fragmentdetail.class.getSimpleName(), "fragment detail");
        FRAGMENT_TAG.put(fragmentgifanimater.class.getSimpleName(), "fragment animater");

    }

    @Override
    public void onFragmentClick(String url, String information, boolean check) {
        transactionFragment(new fragmentdetail(url, information, false));
    }

    @Override
    public void onFragmentClick(String url, String information) {
        transactionFragment(new fragmentdetail(url, information, true));
    }

    @Override
    public void onFragmentClickTabRoBot(String url, String information) {
        transactionFragment(new fragmentdetail(url, information, true));

    }

    public interface OnBackPressedListener {
        void doBack();
    }
}
