package com.it.lloydsbankpoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.it.lloydsbankpoc.presentation.view.HomeScreen
import com.it.lloydsbankpoc.theme.LLOYDSBankPocTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            LLOYDSBankPocTheme {
                HomeScreen(navController = rememberNavController())
            }
        }
    }
}