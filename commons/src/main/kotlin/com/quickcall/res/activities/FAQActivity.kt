package com.quickcall.res.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quickcall.res.R
import com.quickcall.res.compose.extensions.config
import com.quickcall.res.compose.extensions.enableEdgeToEdgeSimple
import com.quickcall.res.compose.screens.FAQScreen
import com.quickcall.res.compose.theme.AppThemeSurface
import com.quickcall.res.extensions.*
import com.quickcall.res.helpers.APP_FAQ
import com.quickcall.res.models.FAQItem
import kotlinx.collections.immutable.toImmutableList

class FAQActivity : BaseComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdgeSimple()
        setContent {
            val isTopAppBarColorIcon by config.isTopAppBarColorIcon.collectAsStateWithLifecycle(initialValue = config.topAppBarColorIcon)
            val isTopAppBarColorTitle by config.isTopAppBarColorTitle.collectAsStateWithLifecycle(initialValue = config.topAppBarColorTitle)
            AppThemeSurface {
                val faqItems = remember { intent.getSerializableExtra(APP_FAQ) as ArrayList<FAQItem> }
                FAQScreen(
                    goBack = ::finish,
                    faqItems = faqItems.toImmutableList(),
                    isTopAppBarColorIcon = isTopAppBarColorIcon,
                    isTopAppBarColorTitle = isTopAppBarColorTitle,
                    onCopy = { faqText ->
                        copyToClipboard(faqText)
                    },
                )
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        changeAutoTheme()
    }

    private fun changeAutoTheme() {
        syncGlobalConfig {
            baseConfig.apply {
                if (isAutoTheme()) {
                    val isUsingSystemDarkTheme = isSystemInDarkMode()
                    textColor = resources.getColor(if (isUsingSystemDarkTheme) R.color.theme_dark_text_color else R.color.theme_light_text_color)
                    backgroundColor =
                        resources.getColor(if (isUsingSystemDarkTheme) R.color.theme_dark_background_color else R.color.theme_light_background_color)
                }
            }
        }
    }
}
