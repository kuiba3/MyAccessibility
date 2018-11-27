package com.example.txf.accessibility_user;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        Log.d("服务","准备开始");
        Intent intent = new Intent(this,MyAccessibility.class);
        startService(intent);
        Log.d("服务","开始成功");
    }
}
