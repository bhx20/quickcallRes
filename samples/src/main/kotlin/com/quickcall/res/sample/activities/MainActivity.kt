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
                    moreAppsFromUs = ::simpleEmpty,
                    startPurchaseActivity = ::simpleEmpty,
                    isTopAppBarColorIcon = isTopAppBarColorIcon,
                )
                AppLaunched()
            }
        }
    }

    @Composable
    private fun AppLaunched() {
        LaunchedEffect(Unit) {
            appLaunchedCompose(
                appId = BuildConfig.APPLICATION_ID,
            )
        }
    }




    private fun setupStartDate() {
        hideKeyboard()
        val datePicker = DatePickerDialog(
            this, getDatePickerDialogTheme(), startDateSetListener, 2013, 5, 6
        )

        datePicker.show()
    }

    override fun getAppLauncherName() = getString(R.string.commons_app_name)

    fun simpleEmpty(){}

    private val startDateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
    }

}
