package com.yellowcode.androidosample.activities;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yellowcode.androidosample.R;
import com.yellowcode.androidosample.utils.NavigationItem;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private NavigationItem nvNotificationChannels;
    private NavigationItem nvPip;
    private NavigationItem nvAutofillFramework;
    private NavigationItem nvDownloadableFonts;
    private NavigationItem nvAutoSizingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        nvNotificationChannels = findViewById(R.id.btn_notification_channels);
        nvPip = findViewById(R.id.btn_pip);
        nvAutofillFramework = findViewById(R.id.btn_auto_fill_framework);
        nvDownloadableFonts = findViewById(R.id.btn_downloadable_font);
        nvAutoSizingTextView = findViewById(R.id.btn_autosizing_textview);

        nvNotificationChannels.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNotificationChannels = new Intent(mContext, NotificationChannelsActivity.class);
                startActivity(intentNotificationChannels);
            }
        });
        nvNotificationChannels.setPinButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ShortcutManager mShortcutManager = mContext.getSystemService(ShortcutManager.class);

                    if (mShortcutManager.isRequestPinShortcutSupported()) {
                        // Assumes there's already a shortcut with the ID "my-shortcut".
                        // The shortcut must be enabled.
                        ShortcutInfo pinShortcutInfo = new ShortcutInfo.Builder(mContext, "shortcut_notification_channels").build();

                        // Create the PendingIntent object only if your app needs to be notified
                        // that the user allowed the shortcut to be pinned. Note that, if the
                        // pinning operation fails, your app isn't notified. We assume here that the
                        // app has implemented a method called createShortcutResultIntent() that
                        // returns a broadcast intent.
                        Intent pinnedShortcutCallbackIntent = mShortcutManager.createShortcutResultIntent(pinShortcutInfo);

                        // Configure the intent so that your app's broadcast receiver gets
                        // the callback successfully.
                        PendingIntent successCallback = PendingIntent.getBroadcast(mContext, 0, pinnedShortcutCallbackIntent, 0);
                        mShortcutManager.requestPinShortcut(pinShortcutInfo, successCallback.getIntentSender());
                    }
                } else {
                    Toast.makeText(mContext, getString(R.string.txt_do_not_support_android_version), Toast.LENGTH_SHORT).show();
                }
            }
        });


        nvPip.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPip = new Intent(mContext, PictureInPictureActivity.class);
                startActivity(intentPip);
                finish();
            }
        });

        nvAutofillFramework.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Implement later...", Toast.LENGTH_SHORT).show();
            }
        });

        nvDownloadableFonts.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDownloadFonts = new Intent(mContext, DownloadableFontsActivity.class);
                startActivity(intentDownloadFonts);
            }
        });

        nvAutoSizingTextView.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAutosizingTextView = new Intent(mContext, AutosizingTextViewActivity.class);
                startActivity(intentAutosizingTextView);
            }
        });
    }
}
