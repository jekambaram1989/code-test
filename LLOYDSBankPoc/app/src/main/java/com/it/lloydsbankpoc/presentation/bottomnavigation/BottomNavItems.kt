package com.it.lloydsbankpoc.presentation.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.it.lloydsbankpoc.core.routes.Routes

data class BottomNavItems(val title: String, val route: String, val icon: ImageVector) {
    companion object {
        val navItems = listOf(
            BottomNavItems("News", Routes.News.route, Icons.Rounded.Home),
            BottomNavItems("World News", Routes.Settings.route, Icons.Rounded.Place)
        )
    }
}