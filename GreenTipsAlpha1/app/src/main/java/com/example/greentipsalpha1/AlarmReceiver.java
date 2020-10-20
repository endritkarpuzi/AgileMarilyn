package com.example.greentipsalpha1;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId = intent.getIntExtra("notificationId", 0);
        String msg = intent.getStringExtra("message");
        Intent mainIntent = new Intent(context, schedule.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "My Notification");

        builder.setSmallIcon(R.drawable.ic_baseline_notification_active_24);
        builder.setContentTitle("It's Time");
        builder.setContentText(msg);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setContentIntent(contentIntent);
        builder.setPriority(NotificationManager.IMPORTANCE_DEFAULT);
        builder.setDefaults(Notification.DEFAULT_ALL);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(notificationId,builder.build());
    }
}