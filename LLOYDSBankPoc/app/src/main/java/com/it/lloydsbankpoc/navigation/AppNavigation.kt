package com.it.lloydsbankpoc.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.it.lloydsbankpoc.core.routes.Routes
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.view.details.DetailsScreen
import com.it.lloydsbankpoc.features.presentation.view.news.NewsScreen
import com.it.lloydsbankpoc.features.presentation.view.worldnews.WorldNewsScreen

@Composable
fun AppNavigation(navController: NavController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.News.route
    ) {
        composable(route = Routes.News.route) {
            NewsScreen(navController = navController, innerPadding = innerPadding)
        }
        composable(
            route = Routes.Settings.route
        ) {
            WorldNewsScreen(navController = navController, innerPadding = innerPadding)
        }
        composable(
            route = "${Routes.Details.route}?details={details}",
            arguments = listOf(navArgument(name = "details") {
                type = NavType.StringType
                defaultValue = ""
            })
        ) {
            val jsonString = it.arguments?.getString("details")
            val article = Gson().fromJson(jsonString, Article::class.java)
            DetailsScreen(innerPadding = innerPadding, article = article, onClick = {
                navController.popBackStack()
            })
        }
    }
}