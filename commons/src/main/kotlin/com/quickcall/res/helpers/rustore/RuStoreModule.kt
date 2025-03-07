package com.quickcall.res.helpers.rustore

import android.app.Application
import android.graphics.Color
import com.quickcall.res.extensions.baseConfig
import com.quickcall.res.extensions.getContrastColor
import com.quickcall.res.extensions.isDynamicTheme
import com.quickcall.res.extensions.isSystemInDarkMode
import ru.rustore.sdk.billingclient.RuStoreBillingClient
import ru.rustore.sdk.billingclient.RuStoreBillingClientFactory
import ru.rustore.sdk.billingclient.presentation.BillingClientTheme
import ru.rustore.sdk.billingclient.provider.BillingClientThemeProvider

object RuStoreModule {
    private lateinit var ruStoreBillingClient: RuStoreBillingClient

    fun install(app: Application, consoleApplicationId: String) {
        ruStoreBillingClient = RuStoreBillingClientFactory.create(
            context = app,
            consoleApplicationId = consoleApplicationId,
            deeplinkScheme = "purchase-scheme",
            themeProvider = BillingClientThemeProviderImpl(app)
            //debugLogs  = true
        )
    }

    class BillingClientThemeProviderImpl(private val app: Application): BillingClientThemeProvider {
        override fun provide(): BillingClientTheme {
            return when {
                app.isDynamicTheme() -> if (app.isSystemInDarkMode()) {
                    BillingClientTheme.Dark
                } else {
                    BillingClientTheme.Light
                }
                app.baseConfig.backgroundColor.getContrastColor() == Color.WHITE -> BillingClientTheme.Dark
                else -> BillingClientTheme.Light
            }
        }
    }

    fun provideRuStoreBillingClient(): RuStoreBillingClient = ruStoreBillingClient

}
