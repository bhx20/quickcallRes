package com.quickcall.res.sample.activities

import android.content.Intent
import com.quickcall.res.activities.BaseSplashActivity

class SplashActivity : BaseSplashActivity() {
    override fun initActivity() {
        if (intent.action == Intent.ACTION_VIEW && intent.data != null) {
            Intent(this, MainActivity::class.java).apply {
                action = Intent.ACTION_VIEW
                data = intent.data
                startActivity(this)
            }
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }
}
