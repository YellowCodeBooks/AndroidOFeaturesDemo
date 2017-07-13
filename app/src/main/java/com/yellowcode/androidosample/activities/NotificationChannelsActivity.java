package com.yellowcode.androidosample.activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yellowcode.androidosample.R;

public class NotificationChannelsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGroup1Channel1;
    private Button btnGroup1Channel2;
    private Button btnGroup2Channel1;

    private int notificationId = 0; // Sets an ID for the notification, so it can be updated.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_channels);

        btnGroup1Channel1 = (Button) findViewById(R.id.btn_group1_channel1);
        btnGroup1Channel2 = (Button) findViewById(R.id.btn_group1_channel2);
        btnGroup2Channel1 = (Button) findViewById(R.id.btn_group2_channel1);

        btnGroup1Channel1.setOnClickListener(this);
        btnGroup1Channel2.setOnClickListener(this);
        btnGroup2Channel1.setOnClickListener(this);

        // Create Groups and Channels
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createGroup("group_1", "Group 1");
            createGroup("group_2", "Group 2");

            createChannel("group_1", "channel_1_1", "Channel 1", true);
            createChannel("group_1", "channel_1_2", "Channel 2", true);
            createChannel("group_2", "channel_2_1", "Channel 1 (Group 2)", false);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnGroup1Channel1.getId()) {
            addNewNotification("channel_1_1");
        } else if (view.getId() == btnGroup1Channel2.getId()) {
            addNewNotification("channel_1_2");
        } else if (view.getId() == btnGroup2Channel1.getId()) {
            addNewNotification("channel_2_1");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createGroup(String groupId, String groupName) {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannelGroup(new NotificationChannelGroup(groupId, groupName));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel(String groupId, String channelId, String channelName, boolean isShowingBadge) {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // The user-visible description of the channel.
        String description = "This Channgel: " + channelName;
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(channelId, channelName, importance);
        // Configure the notification channel.
        mChannel.setDescription(description);
        mChannel.enableLights(true);
        // Sets the notification light color for notifications posted to this
        // channel, if the device supports this feature.
        mChannel.setLightColor(Color.RED);
        mChannel.enableVibration(true);
        mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        mChannel.setShowBadge(isShowingBadge);
        mChannel.setGroup(groupId);
        mNotificationManager.createNotificationChannel(mChannel);
    }

    private void addNewNotification(String channelId) {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationId++; // Increase the notification ID

        Intent intent = new Intent(this, NotificationChannelsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, notificationId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create a notification and set the notification channel.
            Notification notification = new Notification.Builder(NotificationChannelsActivity.this, channelId)
                    .setContentTitle("Message For " + channelId)
                    .setContentText("You've received new messages.")
                    .setSmallIcon(R.drawable.ic_notify_status)
                    .setContentIntent(pendingIntent)
                    .setColor(getColor(R.color.colorTourNoteDark))
                    .build();

            mNotificationManager.notify(notificationId, notification);
        } else {
            // User NotificationCompat for the before Android O
            Notification notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_notify_status)
                    .setContentTitle("Message For " + channelId)
                    .setContentText("You've received new messages.")
                    .setPriority(NotificationManagerCompat.IMPORTANCE_HIGH)
                    .setContentIntent(pendingIntent)
                    .setColor(ContextCompat.getColor(this, R.color.colorTourNoteDark))
                    .build();

            mNotificationManager.notify(notificationId, notification);
        }
    }
}
