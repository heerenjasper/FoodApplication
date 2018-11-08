package com.example.a11502021.foodapplication.util;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

/**
 * Created by 11502021 on 8/11/2018.
 */

public class NotificationExtender extends NotificationExtenderService {

    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        return false;
    }
}
