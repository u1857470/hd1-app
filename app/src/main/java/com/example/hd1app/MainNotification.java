package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

public class MainNotification extends AppCompatActivity {
    private final String CHANNEL_ID = "personal_notification";
    private final int NOTIFICATION_ID = 928;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
    }
    public void notifyMe (View view)
    {
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_notifications_active_black_24dp);
        builder.setContentTitle("HD1");
        builder.setContentText("You will be notified when a new deal pops up");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }

    private void createNotificationChannel()
    {
        CharSequence name = "Personal notification";
        String description = "Include all personal notificaion";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);

        notificationChannel.setDescription(description);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
    }

}
