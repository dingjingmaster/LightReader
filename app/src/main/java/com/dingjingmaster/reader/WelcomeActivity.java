package com.dingjingmaster.reader;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.os.Bundle;

/**
 *  Created by DingJing on 2017/11/22.
 *  欢迎首页，延时跳转
 */

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                startActivity(new Intent(getApplicationContext(), App.class));
                return false;
            }
        }).sendEmptyMessageDelayed(0, 3000);     // 延时 3s 发送

    }
}
