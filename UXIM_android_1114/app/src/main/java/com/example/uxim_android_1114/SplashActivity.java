package com.example.uxim_android_1114;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    Handler handler = new Handler();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 대기
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                showMain();
            }
        }, 1000);
    }
    public void showMain(){
        Intent intent = new Intent(getBaseContext(), NameActivity.class);
        startActivity(intent);
        finish();
    }
}
