package com.it.lloydsbankpoc.features.data.network

import com.it.lloydsbankpoc.core.data.network.ApiEndpoints
import com.it.lloydsbankpoc.features.domain.model.News
import com.it.lloydsbankpoc.features.domain.model.WorldNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiEndpoints.NEWS)
    suspend fun getNews(@Query("country") country: String): Response<News>

    @GET(ApiEndpoints.NEWS)
    suspend fun getWorldNews(@Query("category") category: String): Response<WorldNews>
}