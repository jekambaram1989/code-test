package com.it.lloydsbankpoc.features.data.repository

import com.it.lloydsbankpoc.features.data.network.ApiService
import com.it.lloydsbankpoc.features.domain.model.News
import com.it.lloydsbankpoc.features.domain.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    NewsRepository {
    override suspend fun getNews(country: String): Response<News> {
        return apiService.getNews(country)
    }
}