package com.josecuentas.android_geonavigation;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

/**
 * Created by jcuentas on 20/02/17.
 */

public abstract class  BaseGeoNavigation implements GeoNavigation{
    final Context mContext;

    public BaseGeoNavigation(Context context) {
        mContext = context;
    }

    protected boolean isAppInstaled(String uri) {
        PackageManager pm = mContext.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {}
        return false;
    }

    protected Intent market(Navigation navigation) {
        String market = new StringBuilder()
                .append("market://details?")
                .append("id=")
                .append(navigation.getValue())
                .toString();
        Log.d("TAG", "market() called with: navigation = [" + market + "]");
        return new Intent( Intent.ACTION_VIEW, Uri.parse(market) );
    }

    public enum Navigation {
        WAZE("com.waze"),
        MAPS("com.google.android.apps.maps");
        String value;

        Navigation(String s) {
            value = s;
        }
        public String getValue() {
            return value;
        }

    }
}
