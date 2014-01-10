package com.briangriffey.glass.example;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.TimelineManager;

/**
 * Created by briangriffey on 1/3/14.
 */
public class LaunchActivityService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        TimelineManager manager = TimelineManager.from(this);
        LiveCard card = manager.createLiveCard("awesome");

        RemoteViews view = new RemoteViews(this.getPackageName(), R.layout.live_card_layout);
        view.setTextViewText(android.R.id.text1, "Amazing");
        card.setViews(view);

        Intent menuIntent = new Intent(this, CardActivity.class);
        menuIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        card.setAction(PendingIntent.getActivity(this, 0, menuIntent, 0));

        card.publish(LiveCard.PublishMode.REVEAL);

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
