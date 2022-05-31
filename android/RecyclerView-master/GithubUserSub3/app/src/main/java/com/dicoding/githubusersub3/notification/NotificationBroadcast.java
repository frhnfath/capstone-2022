package com.dicoding.githubusersub3.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.layout.MainActivity;

public class NotificationBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intentNotif = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 102, intentNotif, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("aSwitch", "aSwitch");

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "102")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.baseline_notifications_black_18dp)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.baseline_favorite_black_18dp))
                .setContentTitle(context.getResources().getString(R.string.notification_application))
                .setContentText(context.getResources().getString(R.string.notification))
                .setSubText(context.getResources().getString(R.string.notification_text))
                .setAutoCancel(true);

        Notification notification = builder.build();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("102", "AlarmManager Channel", NotificationManager.IMPORTANCE_DEFAULT);
            builder.setChannelId("102");

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        if (notificationManager != null) {
            notificationManager.notify(2, notification);
        }
    }
}
