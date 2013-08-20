package com.kioskmode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by npcompete on 20/8/13.
 */
public class KioskBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
           Intent ints = new Intent(context,MainActivity.class);
           ints.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(ints);
    }
}
