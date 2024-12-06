package com.it.lloydsbankpoc.features.domain.repository

import com.it.lloydsbankpoc.features.domain.model.WorldNews
import retrofit2.Response


interface WorldNewsRepository {
    suspend fun getWorldNews(category: String): Response<WorldNews>
}