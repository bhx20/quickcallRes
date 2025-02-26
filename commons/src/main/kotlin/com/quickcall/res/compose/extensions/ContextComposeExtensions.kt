package com.quickcall.res.compose.extensions

import android.app.Activity
import android.content.Context
import com.quickcall.res.R
import com.quickcall.res.extensions.baseConfig
import com.quickcall.res.extensions.redirectToRateUs
import com.quickcall.res.extensions.toast
import com.quickcall.res.helpers.BaseConfig

val Context.config: BaseConfig get() = BaseConfig.newInstance(applicationContext)

fun Activity.rateStarsRedirectAndThankYou(stars: Int) {
    if (stars == 5) {
        redirectToRateUs()
    }
    toast(R.string.thank_you)
    baseConfig.wasAppRated = true
}
