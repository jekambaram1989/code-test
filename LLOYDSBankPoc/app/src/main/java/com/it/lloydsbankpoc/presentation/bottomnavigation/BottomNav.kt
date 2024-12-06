package com.it.lloydsbankpoc.presentation.bottomnavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.it.lloydsbankpoc.core.resources.appColor
import com.it.lloydsbankpoc.core.resources.bottomBarSelectedItemTextStyle
import com.it.lloydsbankpoc.core.resources.bottomBarUnselectedItemTextStyle
import com.it.lloydsbankpoc.presentation.bottomnavigation.BottomNavItems.Companion.navItems

@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    BottomNavigation(
        elevation = 5.dp, backgroundColor = appColor
    ) {
        navItems.forEach { items ->
            NavigationBarItem(colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.Black,
                selectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Black
            ), label = {
                Text(
                    text = items.title,
                    style = if (currentDestination == items.route) bottomBarSelectedItemTextStyle() else bottomBarUnselectedItemTextStyle()
                )
            }, selected = currentDestination == items.route, onClick = {
                navController.navigate(items.route) {
                    navController.graph.startDestinationRoute?.let { screenRoute ->
                        popUpTo(screenRoute)
                        launchSingleTop = true
                    }
                }
            }, icon = {
                Icon(
                    imageVector = items.icon, contentDescription = items.title
                )
            })
        }
    }
}