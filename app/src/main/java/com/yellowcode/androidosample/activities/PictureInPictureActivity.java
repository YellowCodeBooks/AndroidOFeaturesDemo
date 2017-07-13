package com.yellowcode.androidosample.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yellowcode.androidosample.R;

public class PictureInPictureActivity extends AppCompatActivity {

    private Button btnEnterPipMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_in_picture);

        btnEnterPipMode = findViewById(R.id.btn_enter_pip_mode);

        btnEnterPipMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    enterPictureInPictureMode();
                } else {
                    Toast.makeText(PictureInPictureActivity.this, getString(R.string.txt_do_not_support_android_version), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
