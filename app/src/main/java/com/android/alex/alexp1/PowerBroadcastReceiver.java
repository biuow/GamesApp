package com.android.alex.alexp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class PowerBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context c, Intent i) {
        // assumes WordService is a registered service
        Intent intent = new Intent(c, MainActivity.class);
        Toast.makeText(c,"Cuidado para não deixar a bateria acabar!",Toast.LENGTH_LONG).show();
        c.startService(intent);
    }
}
