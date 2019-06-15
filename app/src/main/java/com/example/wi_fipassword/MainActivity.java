package com.example.wi_fipassword;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WifiManager manager;
    ListView list;

    BroadcastReceiver receiver;
   ArrayList<Devicenamme> scanresult;

   CustomAdapter adapter;
   int scanval=0;
    @Override
    @SuppressLint("ServiceCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scanresult=new ArrayList<>();
        list=findViewById(R.id.wi_fi_list);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        manager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                getlist();
            }
        },new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));





    }

    @Override
    protected void onResume() {
        manager.startScan();
        super.onResume();

    }


    @Override
    protected void onPause() {

        super.onPause();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public ArrayList<Devicenamme> getlist() {
        List<ScanResult> devecieslist=manager.getScanResults();


        System.out.println("value  2 "+devecieslist.size());

        if (devecieslist.size()>0) {
            for (int i = 0; i < devecieslist.size(); i++) {
                scanresult.add(new Devicenamme(devecieslist.get(i).SSID, devecieslist.get(i).BSSID, devecieslist.get(i).capabilities, devecieslist.get(i).frequency, devecieslist.get(i).timestamp, devecieslist.get(i).level));
            }
        }

        return scanresult;
    }
}
