package com.example.txf.accessibility_user;


import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import java.util.List;

public class MyAccessibility extends AccessibilityService {
    public MyAccessibility() {
    }

    @Override
    protected void onServiceConnected() {
        Log.d("服务","连接成功");
        super.onServiceConnected();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("服务","开始执行");
        return super.onStartCommand(intent, flags, startId);
    }

    private static final String TAG = "服务";


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        String eventText = "";
        Log.d("服务", "==============Start====================");
        switch (eventType) {
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                eventText = "TYPE_VIEW_LONG_CLICKED";
                Log.d("服务",eventText);
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                eventText = "TYPE_WINDOW_STATE_CHANGED";
                Log.d("服务",eventText);
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                eventText = "TYPE_NOTIFICATION_STATE_CHANGED";
                List<CharSequence> texts = event.getText();
                Log.d("服务",eventText);
                Log.d("服务","接到通知");
                for (CharSequence text : texts){
                    Log.d("服务 通知信息",text.toString());
                }

                break;
            case AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE:
                eventText = "CONTENT_CHANGE_TYPE_SUBTREE";
                Log.d("服务",eventText);
                break;
        }
        Log.d(TAG, eventText);
        Log.d(TAG, "=============END=====================");

    }

    @Override
    public void onInterrupt() {

    }
}

