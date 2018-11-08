package com.example.a11502021.foodapplication;

import android.app.Application;

import com.onesignal.OneSignal;

/**
 * Created by 11502021 on 8/11/2018.
 */

public class ApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }

}

