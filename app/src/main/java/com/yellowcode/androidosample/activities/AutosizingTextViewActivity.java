package com.yellowcode.androidosample.activities;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.yellowcode.androidosample.R;

public class AutosizingTextViewActivity extends AppCompatActivity {

    private TextView tvNone;
    private SeekBar sbNone;
    private TextView tvDefault;
    private SeekBar sbDefaule;
    private TextView tvGranularity;
    private SeekBar sbGranularity;
    private TextView tvPresetSize;
    private SeekBar sbPresetSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autosizing_text_view);

        tvNone = findViewById(R.id.tv_none);
        sbNone = findViewById(R.id.sb_none);
        tvDefault = findViewById(R.id.tv_default);
        sbDefaule = findViewById(R.id.sb_default);
        tvGranularity = findViewById(R.id.tv_granularity);
        sbGranularity = findViewById(R.id.sb_granularity);
        tvPresetSize = findViewById(R.id.tv_preset_size);
        sbPresetSize = findViewById(R.id.sb_preset_size);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int widthOriginal = size.x;

        sbNone.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tvNone.getLayoutParams();
                int widthNow = (progress * widthOriginal) / 100;
                layoutParams.width = widthNow;
                tvNone.setLayoutParams(layoutParams);
            }
        });

        sbDefaule.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tvDefault.getLayoutParams();
                int widthNow = (progress * widthOriginal) / 100;
                layoutParams.width = widthNow;
                tvDefault.setLayoutParams(layoutParams);
            }
        });

        sbGranularity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tvGranularity.getLayoutParams();
                int widthNow = (progress * widthOriginal) / 100;
                layoutParams.width = widthNow;
                tvGranularity.setLayoutParams(layoutParams);
            }
        });

        sbPresetSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tvPresetSize.getLayoutParams();
                int widthNow = (progress * widthOriginal) / 100;
                layoutParams.width = widthNow;
                tvPresetSize.setLayoutParams(layoutParams);
            }
        });
    }
}
