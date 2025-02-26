package com.quickcall.res.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.quickcall.res.extensions.syncGlobalConfig
import com.quickcall.res.helpers.MyContentProvider

class RightBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == MyContentProvider.ACTION_GLOBAL_CONFIG_UPDATED) {
            context?.syncGlobalConfig()
        }
    }
}
