package com.example.zhaoxu.lottery.Utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.example.zhaoxu.lottery.Info.GlobalParams;

import java.net.URL;

/**
 * Created by Administrator on 2016/9/19.
 */
public class NetUtils {

    public static boolean checkNet(Context context) {
        boolean isWifi = checkWifiConnection(context);

        boolean isMobile = checkMobileConnection(context);

        if (isMobile) {
            readAPN(context);
        }

        if (!isMobile && !isWifi) {
            return false;
        } else {
            return true;
        }
    }

    private static void readAPN(Context context) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://telephony/carries/preferapn");
        Cursor cursor = resolver.query(uri, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            GlobalParams.PROXY = cursor.getString(cursor.getColumnIndex("proxy"));
            GlobalParams.PORT = cursor.getInt(cursor.getColumnIndex("port"));
        }
    }

    private static boolean checkMobileConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    private static boolean checkWifiConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }
}
