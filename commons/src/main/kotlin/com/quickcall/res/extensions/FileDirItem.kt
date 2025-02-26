package com.quickcall.res.extensions

import android.content.Context
import com.quickcall.res.models.FileDirItem

fun FileDirItem.isRecycleBinPath(context: Context): Boolean {
    return path.startsWith(context.recycleBinPath)
}
