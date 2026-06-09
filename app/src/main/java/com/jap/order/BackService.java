package com.jap.order;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

public class BackService extends AccessibilityService {
    public static BackService instance;

    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
        instance = this;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) { /* 사용 안 함 */ }

    @Override
    public void onInterrupt() { }

    @Override
    public boolean onUnbind(android.content.Intent intent) {
        instance = null;
        return super.onUnbind(intent);
    }

    // 다른 곳에서 호출: 시스템 '뒤로가기' 한 번
    public static boolean pressBack() {
        if (instance != null) {
            return instance.performGlobalAction(GLOBAL_ACTION_BACK);
        }
        return false;
    }
}
