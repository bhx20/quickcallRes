package com.quickcall.res.dialogs

import androidx.appcompat.app.AlertDialog
import com.quickcall.res.R
import com.quickcall.res.activities.BaseSimpleActivity
import com.quickcall.res.databinding.DialogExportBlockedNumbersBinding
import com.quickcall.res.extensions.*
import com.quickcall.res.helpers.BLOCKED_NUMBERS_EXPORT_EXTENSION
import com.quickcall.res.helpers.ensureBackgroundThread
import java.io.File

class ExportBlockedNumbersDialog(
    val activity: BaseSimpleActivity,
    val path: String,
    val hidePath: Boolean,
    callback: (file: File) -> Unit,
) {
    private var realPath = path.ifEmpty { activity.internalStoragePath }
    private val config = activity.baseConfig

    init {
        val view = DialogExportBlockedNumbersBinding.inflate(activity.layoutInflater, null, false).apply {
            exportBlockedNumbersFolder.text = activity.humanizePath(realPath)
            exportBlockedNumbersFilename.setText("${activity.getString(R.string.blocked_numbers)}_${activity.getCurrentFormattedDateTime()}")

            if (hidePath) {
                exportBlockedNumbersFolderLabel.beGone()
                exportBlockedNumbersFolder.beGone()
            } else {
                exportBlockedNumbersFolder.setOnClickListener {

                }
            }
        }

        activity.getAlertDialogBuilder()
            .setPositiveButton(R.string.ok, null)
            .setNegativeButton(R.string.cancel, null)
            .apply {
                activity.setupDialogStuff(view.root, this, R.string.export_blocked_numbers) { alertDialog ->
                    alertDialog.showKeyboard(view.exportBlockedNumbersFilename)
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                        val filename = view.exportBlockedNumbersFilename.value
                        when {
                            filename.isEmpty() -> activity.toast(R.string.empty_name)
                            filename.isAValidFilename() -> {
                                val file = File(realPath, "$filename$BLOCKED_NUMBERS_EXPORT_EXTENSION")
                                if (!hidePath && file.exists()) {
                                    activity.toast(R.string.name_taken)
                                    return@setOnClickListener
                                }

                                ensureBackgroundThread {
                                    config.lastBlockedNumbersExportPath = file.absolutePath.getParentPath()
                                    callback(file)
                                    alertDialog.dismiss()
                                }
                            }

                            else -> activity.toast(R.string.invalid_name)
                        }
                    }
                }
            }
    }
}
