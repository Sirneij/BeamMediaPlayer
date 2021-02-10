package com.example.mediaplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static com.example.mediaplayer.ApplicationClass.ACTION_NEXT;
import static com.example.mediaplayer.ApplicationClass.ACTION_PLAY;
import static com.example.mediaplayer.ApplicationClass.ACTION_PREVIOUS;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String actionName = intent.getAction();
        Intent newServiceIntent = new Intent(context, MusicService.class);
        if (actionName!=null){
            switch (actionName){
                case ACTION_PLAY:
                    newServiceIntent.putExtra("ActionName", "playPause");
                    context.startService(newServiceIntent);
                    break;
                case ACTION_NEXT:
                    newServiceIntent.putExtra("ActionName", "next");
                    context.startService(newServiceIntent);
                    break;
                case ACTION_PREVIOUS:
                    newServiceIntent.putExtra("ActionName", "previous");
                    context.startService(newServiceIntent);
                    break;
            }
        }
    }
}
