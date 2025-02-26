package com.quickcall.res.activities

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.*
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.core.net.toUri
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quickcall.res.R
import com.quickcall.res.compose.alert_dialog.rememberAlertDialogState
import com.quickcall.res.compose.extensions.config
import com.quickcall.res.compose.extensions.enableEdgeToEdgeSimple
import com.quickcall.res.compose.extensions.rateStarsRedirectAndThankYou
import com.quickcall.res.compose.screens.*
import com.quickcall.res.compose.theme.AppThemeSurface
import com.quickcall.res.dialogs.ConfirmationAdvancedAlertDialog
import com.quickcall.res.dialogs.RateStarsAlertDialog
import com.quickcall.res.extensions.*
import com.quickcall.res.helpers.*
import com.quickcall.res.models.FAQItem

class AboutActivity : BaseComposeActivity() {
    private val appName get() = intent.getStringExtra(APP_NAME) ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdgeSimple()
        setContent {
            val isTopAppBarColorIcon by config.isTopAppBarColorIcon.collectAsStateWithLifecycle(initialValue = config.topAppBarColorIcon)
            val isTopAppBarColorTitle by config.isTopAppBarColorTitle.collectAsStateWithLifecycle(initialValue = config.topAppBarColorTitle)
            AppThemeSurface {
                val rateStarsAlertDialogState = getRateStarsAlertDialogState()
                val onRateUsClickAlertDialogState = getOnRateUsClickAlertDialogState(rateStarsAlertDialogState::show)
                AboutScreen(
                    goBack = ::finish,
                    aboutSection = {
                        AboutNewSection(
                            appName = appName,
                            appVersion = intent.getStringExtra(APP_VERSION_NAME) ?: "",
                            onRateUsClick = {
                                onRateUsClick(
                                    showConfirmationAdvancedDialog = onRateUsClickAlertDialogState::show,
                                    showRateStarsDialog = rateStarsAlertDialogState::show
                                )
                            },
                            onMoreAppsClick = ::launchMoreAppsFromUsIntent,
                            onPrivacyPolicyClick = ::onPrivacyPolicyClick,
                            onFAQClick = ::launchFAQActivity,
                            onTipJarClick = ::onTipJarClick,
                            showGithub = showGithub(),
                            onGithubClick = ::onGithubClick
                        )
                    },
                    isTopAppBarColorIcon = isTopAppBarColorIcon,
                    isTopAppBarColorTitle = isTopAppBarColorTitle,
                )
            }
        }
    }

    @Composable
    private fun getRateStarsAlertDialogState() =
        rememberAlertDialogState().apply {
            DialogMember {
                RateStarsAlertDialog(
                    alertDialogState = this,
                    onRating = ::rateStarsRedirectAndThankYou
                )
            }
        }

    @Composable
    private fun getOnRateUsClickAlertDialogState(showRateStarsDialog: () -> Unit) =
        rememberAlertDialogState().apply {
            DialogMember {
                ConfirmationAdvancedAlertDialog(
                    alertDialogState = this,
                    message = "${getString(R.string.before_asking_question_read_faq)}\n\n${getString(R.string.make_sure_latest)}",
                    messageId = null,
                    positive = R.string.read_faq,
                    negative = R.string.skip
                ) { success ->
                    if (success) {
                        launchFAQActivity()
                    } else {
                        launchRateUsPrompt(showRateStarsDialog)
                    }
                }
            }
        }

    private fun launchFAQActivity() {
        val faqItems = intent.getSerializableExtra(APP_FAQ) as ArrayList<FAQItem>
        Intent(applicationContext, FAQActivity::class.java).apply {
            putExtra(
                APP_ICON_IDS,
                intent.getIntegerArrayListExtra(APP_ICON_IDS) ?: ArrayList<String>()
            )
            putExtra(APP_LAUNCHER_NAME, intent.getStringExtra(APP_LAUNCHER_NAME) ?: "")
            putExtra(APP_FAQ, faqItems)
            startActivity(this)
        }
    }

    private fun onRateUsClick(
        showConfirmationAdvancedDialog: () -> Unit,
        showRateStarsDialog: () -> Unit,
    ) {
        if (baseConfig.wasBeforeRateShown) {
            launchRateUsPrompt(showRateStarsDialog)
        } else {
            baseConfig.wasBeforeRateShown = true
            showConfirmationAdvancedDialog()
        }
    }

    private fun launchRateUsPrompt(
        showRateStarsDialog: () -> Unit,
    ) {
        if (baseConfig.wasAppRated) {
            redirectToRateUs()
        } else {
            showRateStarsDialog()
        }
    }

    private fun onPrivacyPolicyClick() {
        val url =  "https://sites.google.com/";
        launchViewIntent(url)
    }

    private fun onTipJarClick() {

    }

    private fun onGithubClick() {
        val repositoryName = intent.getStringExtra(APP_REPOSITORY_NAME) ?: return
        val url = "https://github.com/"
        launchViewIntent(url)
    }

    @Composable
    private fun showGithub() =
        remember { !intent.getStringExtra(APP_REPOSITORY_NAME).isNullOrEmpty() }

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
                    finish()
                    startActivity(intent)
                }
            }
        }
        return
    }
}
