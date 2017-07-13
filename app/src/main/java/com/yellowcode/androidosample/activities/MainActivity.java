package com.yellowcode.androidosample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yellowcode.androidosample.R;
import com.yellowcode.androidosample.utils.NavigationItem;

public class MainActivity extends AppCompatActivity {

    private NavigationItem nvNotificationChannels;
    private NavigationItem nvPip;
    private NavigationItem nvAutofillFramework;
    private NavigationItem nvDownloadableFonts;
    private NavigationItem nvAutoSizingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nvNotificationChannels = findViewById(R.id.btn_notification_channels);
        nvPip = findViewById(R.id.btn_pip);
        nvAutofillFramework = findViewById(R.id.btn_auto_fill_framework);
        nvDownloadableFonts = findViewById(R.id.btn_downloadable_font);
        nvAutoSizingTextView = findViewById(R.id.btn_autosizing_textview);

        nvNotificationChannels.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNotificationChannels = new Intent(MainActivity.this, NotificationChannelsActivity.class);
                startActivity(intentNotificationChannels);
            }
        });


        nvPip.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPip = new Intent(MainActivity.this, PictureInPictureActivity.class);
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
                Intent intentDownloadFonts = new Intent(MainActivity.this, DownloadableFontsActivity.class);
                startActivity(intentDownloadFonts);
            }
        });

        nvAutoSizingTextView.setNavigationButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAutosizingTextView = new Intent(MainActivity.this, AutosizingTextViewActivity.class);
                startActivity(intentAutosizingTextView);
            }
        });
    }
}
