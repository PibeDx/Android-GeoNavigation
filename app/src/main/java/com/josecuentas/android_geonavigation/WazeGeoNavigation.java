package com.josecuentas.android_geonavigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by jcuentas on 20/02/17.
 * base: https://www.waze.com/es-419/about/dev#android_api
 */

public class WazeGeoNavigation extends BaseGeoNavigation{

    public WazeGeoNavigation(Context context) {
        super(context);
    }

    @Override public void go(double latitude, double longitude) {
        String uri = new StringBuilder()
                .append("waze://?")
                .append("ll=")
                .append(latitude)
                .append(",")
                .append(longitude)
                .append(",&navigate=yes").toString();

        if (isAppInstaled(Navigation.WAZE.getValue())) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            mContext.startActivity(intent);
        } else {
            mContext.startActivity(market(Navigation.MAPS));
        }
    }
}
