package com.quickcall.res.sample

import com.quickcall.res.QuickApp
import com.quickcall.res.helpers.rustore.RuStoreModule

class App : QuickApp() {
    override fun onCreate() {
        super.onCreate()

        RuStoreModule.install(this, "309929407")
    }
}
