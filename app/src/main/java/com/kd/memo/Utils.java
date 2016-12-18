package com.kd.memo;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/**
 * Created by QETO on 12/18/2016.
 */

public class Utils {
    public static String LogTag = "test";
    public static String EXTRA_MSG = "extra_msg";


    public static boolean canDrawOverlays(Context context){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }else{
            return Settings.canDrawOverlays(context);
        }


    }
}
