package com.quickcall.res.compose.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.quickcall.res.R
import com.quickcall.res.compose.alert_dialog.rememberAlertDialogState
import com.quickcall.res.dialogs.ConfirmationAlertDialog
import com.quickcall.res.extensions.launchViewIntent



@Composable
fun CheckAppOnSdCard() {
    val context = LocalContext.current.getComponentActivity()
    val confirmationDialogAlertDialogState = rememberAlertDialogState().apply {
        DialogMember {
            ConfirmationAlertDialog(
                alertDialogState = this,
                messageId = R.string.app_on_sd_card,
                positive = R.string.ok,
                negative = null
            ) {}
        }
    }
    LaunchedEffect(Unit) {
        context.appOnSdCardCheckCompose(confirmationDialogAlertDialogState::show)
    }
}
