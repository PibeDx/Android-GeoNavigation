package com.josecuentas.android_geonavigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by jcuentas on 20/02/17.
 * base: https://developers.google.com/maps/documentation/android-api/intents?hl=es-419#iniciar_la_navegacion_paso_a_paso
 */

public class MapsGeoNavigation extends BaseGeoNavigation {

    public MapsGeoNavigation(Context context) {
        super(context);
    }

    @Override public void go(double latitude, double longitude) {
        /*String uri = new StringBuilder().append("http://maps.google.com/maps?").append("daddr=").append(latitude).append(",").append(longitude).toString();*/
        //intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        String uri = new StringBuilder()
                .append("google.navigation:")
                .append("q=")
                .append(latitude)
                .append(",")
                .append(longitude)
                .append("&mode=d").toString();
        if (isAppInstaled(Navigation.MAPS.getValue())) {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            mContext.startActivity(intent);
        } else {
            mContext.startActivity(market(Navigation.MAPS));
        }
    }
}
