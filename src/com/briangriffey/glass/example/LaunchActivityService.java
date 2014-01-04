package com.briangriffey.glass.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by briangriffey on 1/3/14.
 */
public class LaunchActivityService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Intent launchActivityIntent = new Intent(this, CardActivity.class);
        startActivity(launchActivityIntent);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
