  package com.wanfadger.rentaboat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavDeepLinkBuilder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNELID = "channelId" ;
    private static final int NOTIFICATION_ID = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendFakeNotification();
    }

    private void sendFakeNotification() {

        NotificationManager notificationManager = getSystemService(NotificationManager.class);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //create notification importance
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            String name ="boatNotification";
            String description = "Starts a specific boat activity";

            //create notification channel
            NotificationChannel channel = new NotificationChannel(CHANNELID , name , importance);
            channel.setDescription(description);
            //register it to notification manager
            notificationManager.createNotificationChannel(channel);
        }

        Bundle args =  new BoatDetailFragmentArgs.Builder()
                .setId(3)
                .build().toBundle();

        //pending Intent
        PendingIntent pendingIntent = new NavDeepLinkBuilder(this)
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.boatDetailFragment)
                .setArguments(args)
                .createPendingIntent();

        //set notification content
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this , CHANNELID); // notificationManagerCompat = new NotificationManagerCompat(this);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentText("Boat on Sale")
                .setContentInfo("click to open shop")
                .setContentIntent(pendingIntent)
        ;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            builder.setChannelId(CHANNELID);
        }else{
            builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        }

        notificationManager.notify(NOTIFICATION_ID , builder.build());
    }
}