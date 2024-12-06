package com.it.lloydsbankpoc.features.presentation.view.worldnews

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.it.lloydsbankpoc.core.data.util.DataState
import com.it.lloydsbankpoc.features.domain.model.WorldNews
import com.it.lloydsbankpoc.features.presentation.view.news.ErrorView
import com.it.lloydsbankpoc.features.presentation.view.news.LoadingView
import com.it.lloydsbankpoc.features.presentation.view.news.NewsViewmodel

@Composable
fun WorldNewsScreen(
    navController: NavController,
    innerPadding: PaddingValues,
    viewmodel: NewsViewmodel = hiltViewModel()
) {
    when (viewmodel.worldNews.value) {
        is DataState.Error -> {
            ErrorView(
                innerPadding,
                ((viewmodel.worldNews.value as DataState.Error<List<WorldNews>>).message)
            )
        }

        is DataState.Loading -> {
            LoadingView(innerPadding)
        }

        is DataState.Success -> {
            WorldNewsSuccessView(
                innerPadding,
                navController,
                (viewmodel.worldNews.value as DataState.Success<List<WorldNews>>).data
            )
        }
    }
}