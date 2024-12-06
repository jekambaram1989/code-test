package com.it.lloydsbankpoc.features.domain.repository

import com.it.lloydsbankpoc.features.domain.model.News
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(country: String): Response<News>
}