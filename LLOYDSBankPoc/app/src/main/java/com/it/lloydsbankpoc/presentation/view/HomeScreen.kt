package com.it.lloydsbankpoc.presentation.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.it.lloydsbankpoc.core.resources.backgroundColor
import com.it.lloydsbankpoc.navigation.AppNavigation
import com.it.lloydsbankpoc.presentation.bottomnavigation.BottomNav

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = backgroundColor,
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { innerPadding ->
        AppNavigation(navController = navController, innerPadding = innerPadding)
    }
}