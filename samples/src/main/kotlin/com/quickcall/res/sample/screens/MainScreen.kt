package com.quickcall.res.sample.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import com.quickcall.res.R
import com.quickcall.res.compose.extensions.MyDevices
import com.quickcall.res.compose.lists.SimpleScaffold
import com.quickcall.res.compose.lists.simpleTopAppBarColors
import com.quickcall.res.compose.lists.topAppBarInsets
import com.quickcall.res.compose.lists.topAppBarPaddings
import com.quickcall.res.compose.menus.ActionItem
import com.quickcall.res.compose.menus.ActionMenu
import com.quickcall.res.compose.menus.OverflowMode
import com.quickcall.res.compose.theme.AppThemeSurface
import com.quickcall.res.compose.theme.LocalTheme
import com.quickcall.res.compose.theme.SimpleTheme
import com.quickcall.res.compose.theme.actionModeColor
import com.quickcall.res.compose.theme.model.Theme

@Composable
fun MainScreen(
    openColorCustomization: () -> Unit,
    manageBlockedNumbers: () -> Unit,
    showComposeDialogs: () -> Unit,
    openTestButton: () -> Unit,
    showMoreApps: Boolean,
    openAbout: () -> Unit,
    moreAppsFromUs: () -> Unit,
    startPurchaseActivity: () -> Unit,
    isTopAppBarColorIcon: Boolean = false,
) {
    SimpleScaffold(
        customTopBar = { scrolledColor: Color, _: MutableInteractionSource, scrollBehavior: TopAppBarScrollBehavior, statusBarColor: Int, colorTransitionFraction: Float, contrastColor: Color ->

            val iconColor = if (isTopAppBarColorIcon) MaterialTheme.colorScheme.primary else null
            TopAppBar(
                title = {},
                actions = {
                    val actionMenus = remember {
                        buildActionMenuItems(
                            showMoreApps = showMoreApps,
                            openAbout = openAbout,
                            moreAppsFromUs = moreAppsFromUs
                        )
                    }
                    var isMenuVisible by remember { mutableStateOf(false) }
                    ActionMenu(
                        items = actionMenus,
                        numIcons = 2,
                        isMenuVisible = isMenuVisible,
                        onMenuToggle = { isMenuVisible = it },
                        iconsColor = iconColor ?: scrolledColor
                    )
                },
                scrollBehavior = scrollBehavior,
                colors = simpleTopAppBarColors(statusBarColor, colorTransitionFraction, contrastColor),
                modifier = Modifier.topAppBarPaddings(),
                windowInsets = topAppBarInsets()
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = openColorCustomization
            ) {
                Text(stringResource(id = R.string.color_customization))
            }
            Button(
                onClick = startPurchaseActivity
            ) {
                Text("Purchase")
            }
            Button(
                onClick = manageBlockedNumbers
            ) {
                Text("Manage blocked numbers")
            }
            Button(
                onClick = showComposeDialogs
            ) {
                Text("Compose dialogs")
            }
            Button(
                onClick = openTestButton
            ) {
                Text("Test button")
            }
        }
    }
}

private fun buildActionMenuItems(
    showMoreApps: Boolean,
    openAbout: () -> Unit,
    moreAppsFromUs: () -> Unit
): ImmutableList<ActionItem> {
    val list = mutableListOf<ActionItem>()
    list += ActionItem(
        R.string.about,
        icon = Icons.Outlined.Info,
        doAction = openAbout,
        overflowMode = OverflowMode.NEVER_OVERFLOW,
    )
    if (showMoreApps) {
        list += ActionItem(
            R.string.more_apps_from_us,
            doAction = moreAppsFromUs,
            overflowMode = OverflowMode.ALWAYS_OVERFLOW,
        )
    }
    return list.toImmutableList()
}

@Composable
@ReadOnlyComposable
private fun actionModeBgColor(): Color =
    if (LocalTheme.current is Theme.SystemDefaultMaterialYou) {
        SimpleTheme.colorScheme.primaryContainer
    } else {
        actionModeColor
    }

@Composable
@MyDevices
private fun MainScreenPreview() {
    AppThemeSurface {
        MainScreen(
            openColorCustomization = {},
            manageBlockedNumbers = {},
            showComposeDialogs = {},
            openTestButton = {},
            showMoreApps = true,
            openAbout = {},
            moreAppsFromUs = {},
            startPurchaseActivity = {},
        )
    }
}
