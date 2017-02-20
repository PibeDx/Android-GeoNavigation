package com.josecuentas.android_geonavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String PACKAGE_WAZE = "com.waze";
    public static final String PACKAGE_MAPS = "com.google.android.apps.maps";
    private GeoNavigation mGeoNavigation;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.butWaze).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                    mGeoNavigation = new WazeGeoNavigation(MainActivity.this);
                    mGeoNavigation.go(-12.092288, -77.033567);
            }
        });

        findViewById(R.id.butMaps).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                    mGeoNavigation = new MapsGeoNavigation(MainActivity.this);
                    mGeoNavigation.go(-12.092288, -77.033567);
            }
        });
    }
}
