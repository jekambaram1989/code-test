package com.it.lloydsbankpoc.features.data.repository

import com.it.lloydsbankpoc.features.data.network.ApiService
import com.it.lloydsbankpoc.features.domain.model.WorldNews
import com.it.lloydsbankpoc.features.domain.repository.WorldNewsRepository
import retrofit2.Response
import javax.inject.Inject

class WorldNewsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    WorldNewsRepository {

    override suspend fun getWorldNews(category: String): Response<WorldNews> {
        return apiService.getWorldNews(category)
    }
}