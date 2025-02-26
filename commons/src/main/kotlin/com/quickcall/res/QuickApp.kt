package com.quickcall.res
import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.quickcall.res.extensions.appLockManager
import com.quickcall.res.extensions.checkUseEnglish

open class QuickApp : Application() {

    open val isAppLockFeatureAvailable = false

    override fun onCreate() {
        super.onCreate()
        checkUseEnglish()
        setupAppLockManager()
    }

    private fun setupAppLockManager() {
        if (isAppLockFeatureAvailable) {
            ProcessLifecycleOwner.get().lifecycle.addObserver(appLockManager)
        }
    }
}
