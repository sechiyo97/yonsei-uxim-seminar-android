package com.example.uxim_android_1121;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    Handler handler = new Handler();
    private SharedPreferences appData;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 대기
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                // 설정값 객체 불러오기
                appData = getSharedPreferences("appData", MODE_PRIVATE);
                // 설정값 가져오기
                Boolean first = appData.getBoolean("FIRST", true); // 데이터 없는 경우 가져옴

                if (first) showName();
                else showMain();
            }
        }, 1000);
    }
    public void showName(){
        Intent intent = new Intent(getBaseContext(), NameActivity.class);
        startActivity(intent);
        finish();
    }
    public void showMain(){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
