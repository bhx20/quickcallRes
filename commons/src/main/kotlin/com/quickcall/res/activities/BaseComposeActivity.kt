package com.quickcall.res.activities

import androidx.activity.ComponentActivity
import com.quickcall.res.helpers.REQUEST_APP_UNLOCK

abstract class BaseComposeActivity : ComponentActivity() {

    override fun onResume() {
        super.onResume()
        maybeLaunchAppUnlockActivity(REQUEST_APP_UNLOCK)
    }
}
