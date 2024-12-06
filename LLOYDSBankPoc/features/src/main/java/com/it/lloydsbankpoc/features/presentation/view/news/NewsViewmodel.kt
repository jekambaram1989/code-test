package com.it.lloydsbankpoc.features.presentation.view.news

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.lloydsbankpoc.core.data.util.DataState
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.domain.model.WorldNews
import com.it.lloydsbankpoc.features.domain.usecase.NewsUseCase
import com.it.lloydsbankpoc.features.domain.usecase.WorldNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewmodel @Inject constructor(
    private val newsUseCase: NewsUseCase,
    private val worldNewsUseCase: WorldNewsUseCase
) : ViewModel() {

    private val _news = mutableStateOf<DataState<List<Article>>>(DataState.Loading)
    val news: MutableState<DataState<List<Article>>> = _news

    private val _worldNews = mutableStateOf<DataState<List<WorldNews>>>(DataState.Loading)
    val worldNews: MutableState<DataState<List<WorldNews>>> = _worldNews

    init {
        getNews()
        getWorldNews()
    }

    fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
            _news.value = DataState.Loading
            news.value = newsUseCase("us")
        }
    }

    private fun getWorldNews() {
        viewModelScope.launch(Dispatchers.IO) {
            _worldNews.value = DataState.Loading
            _worldNews.value = worldNewsUseCase()
        }
    }
}