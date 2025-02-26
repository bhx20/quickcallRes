package com.quickcall.res.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.quickcall.res.R
import com.quickcall.res.activities.BaseSimpleActivity
import com.quickcall.res.compose.alert_dialog.*
import com.quickcall.res.compose.extensions.MyDevices
import com.quickcall.res.compose.theme.AppThemeSurface
import com.quickcall.res.databinding.DialogOpenDeviceSettingsBinding
import com.quickcall.res.extensions.getAlertDialogBuilder
import com.quickcall.res.extensions.openDeviceSettings
import com.quickcall.res.extensions.setupDialogStuff

class OpenDeviceSettingsDialog(val activity: BaseSimpleActivity, message: String) {

    init {
        activity.apply {
            val view = DialogOpenDeviceSettingsBinding.inflate(layoutInflater, null, false)
            view.openDeviceSettings.text = message
            getAlertDialogBuilder()
                .setNegativeButton(R.string.close, null)
                .setPositiveButton(R.string.go_to_settings) { _, _ ->
                    openDeviceSettings()
                }.apply {
                    setupDialogStuff(view.root, this)
                }
        }
    }
}

@Composable
fun OpenDeviceSettingsAlertDialog(
    alertDialogState: AlertDialogState,
    message: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    AlertDialog(
        containerColor = dialogContainerColor,
        modifier = modifier
            .dialogBorder,
        onDismissRequest = alertDialogState::hide,
        shape = dialogShape,
        tonalElevation = dialogElevation,
        text = {
            Text(
                fontSize = 16.sp,
                text = message,
                color = dialogTextColor
            )
        },
        dismissButton = {
            TextButton(onClick = alertDialogState::hide) {
                Text(text = stringResource(id = R.string.close))
            }
        },
        confirmButton = {
            TextButton(onClick = {
                context.openDeviceSettings()
                alertDialogState.hide()
            }) {
                Text(text = stringResource(id = R.string.go_to_settings))
            }
        },
    )
}

@Composable
@MyDevices
private fun OpenDeviceSettingsAlertDialogPreview() {
    AppThemeSurface {
        OpenDeviceSettingsAlertDialog(
            alertDialogState = rememberAlertDialogState(),
            message = "Test dialog"
        )
    }
}
