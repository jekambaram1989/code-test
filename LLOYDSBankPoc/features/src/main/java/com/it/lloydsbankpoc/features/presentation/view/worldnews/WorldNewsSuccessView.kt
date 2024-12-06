package com.it.lloydsbankpoc.features.presentation.view.worldnews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.it.lloydsbankpoc.core.resources.padding
import com.it.lloydsbankpoc.features.domain.model.WorldNews

@Composable
fun WorldNewsSuccessView(
    innerPadding: PaddingValues, navController: NavController, worldNews: List<WorldNews>
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(padding)
    ) {
        ScrollableTab(navController, worldNews)
    }
}