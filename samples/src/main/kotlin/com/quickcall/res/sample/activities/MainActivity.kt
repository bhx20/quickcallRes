package com.quickcall.res.sample.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quickcall.res.activities.BaseSimpleActivity
import com.quickcall.res.activities.ManageBlockedNumbersActivity
import com.quickcall.res.compose.alert_dialog.AlertDialogState
import com.quickcall.res.compose.alert_dialog.rememberAlertDialogState
import com.quickcall.res.compose.extensions.*
import com.quickcall.res.compose.theme.AppThemeSurface
import com.quickcall.res.dialogs.RateStarsAlertDialog
import com.quickcall.res.dialogs.SecurityDialog
import com.quickcall.res.extensions.*
import com.quickcall.res.helpers.LICENSE_AUTOFITTEXTVIEW
import com.quickcall.res.helpers.SHOW_ALL_TABS
import com.quickcall.res.models.FAQItem
import com.quickcall.res.sample.BuildConfig
import com.quickcall.res.sample.R
import com.quickcall.res.sample.screens.MainScreen

class MainActivity : BaseSimpleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        isMaterialActivity = true
        super.onCreate(savedInstanceState)
        appLaunched(BuildConfig.APPLICATION_ID)
        enableEdgeToEdgeSimple()
        setContent {
            val isTopAppBarColorIcon by config.isTopAppBarColorIcon.collectAsStateWithLifecycle(initialValue = config.topAppBarColorIcon)
            AppThemeSurface {
                val showMoreApps = onEventValue { !resources.getBoolean(com.quickcall.res.R.bool.hide_google_relations) }

                MainScreen(
                    openColorCustomization = ::simpleEmpty,
                    manageBlockedNumbers = {
                        startActivity(Intent(this@MainActivity, ManageBlockedNumbersActivity::class.java))
                    },
                    showComposeDialogs = {
                        startActivity(Intent(this@MainActivity, TestDialogActivity::class.java))
                    },
                    openTestButton = ::setupStartDate,
                    showMoreApps = showMoreApps,
                    openAbout = ::simpleEmpty,
                    moreAppsFromUs = ::launchMoreAppsFromUsIntent,
                    startPurchaseActivity = ::simpleEmpty,
                    isTopAppBarColorIcon = isTopAppBarColorIcon,
                )
                AppLaunched()
            }
        }
    }

    @Composable
    private fun AppLaunched(
        rateStarsAlertDialogState: AlertDialogState = getRateStarsAlertDialogState(),
    ) {
        LaunchedEffect(Unit) {
            appLaunchedCompose(
                appId = BuildConfig.APPLICATION_ID,
                showRateUsDialog = rateStarsAlertDialogState::show,
            )
        }
    }

    @Composable
    private fun getRateStarsAlertDialogState() = rememberAlertDialogState().apply {
        DialogMember {
            RateStarsAlertDialog(alertDialogState = this, onRating = ::rateStarsRedirectAndThankYou)
        }
    }



    private fun setupStartDate() {
        hideKeyboard()
        val datePicker = DatePickerDialog(
            this, getDatePickerDialogTheme(), startDateSetListener, 2024, 12, 30
        )

        datePicker.show()
    }

    fun simpleEmpty(){}

    private val startDateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
    }

    override fun getAppLauncherName() = getString(R.string.commons_app_name)

    override fun getAppIconIDs() = arrayListOf(
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_one,
        R.mipmap.ic_launcher_two,
        R.mipmap.ic_launcher_three,
        R.mipmap.ic_launcher_four,
        R.mipmap.ic_launcher_five,
        R.mipmap.ic_launcher_six,
        R.mipmap.ic_launcher_seven,
        R.mipmap.ic_launcher_eight,
        R.mipmap.ic_launcher_nine,
        R.mipmap.ic_launcher_ten,
        R.mipmap.ic_launcher_eleven
    )

    override fun getRepositoryName() = "Gallery"
}
