package com.quickcall.res.models

import com.quickcall.res.helpers.MyContentProvider

data class GlobalConfig(
    val themeType: Int,
    val textColor: Int,
    val backgroundColor: Int,
    val primaryColor: Int,
    val accentColor: Int,
    val appIconColor: Int,
    val showCheckmarksOnSwitches: Boolean,
    val lastUpdatedTS: Int = 0,
)

fun GlobalConfig?.isGlobalThemingEnabled(): Boolean {
    return this != null && themeType != MyContentProvider.GLOBAL_THEME_DISABLED
}
