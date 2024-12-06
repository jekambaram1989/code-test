package com.it.lloydsbankpoc.features.domain.usecase

import com.it.lloydsbankpoc.core.data.network.ApiEndpoints
import com.it.lloydsbankpoc.core.data.util.DataState
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.domain.repository.NewsRepository
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke(country: String): DataState<List<Article>> {
        return try {
            val response = repository.getNews(country)
            if (response.isSuccessful) {
                val result = response.body()?.let {
                    it.articles.filter { filterItem ->
                        filterItem.source!!.name != null && filterItem.source.name != "[Removed]"
                    }.onEach { eachItem ->
                        eachItem.source!!.name = eachItem.source.name!!.uppercase()
                        eachItem.title = eachItem.title ?: ""
                        eachItem.description = eachItem.description ?: ""
                        eachItem.author = eachItem.author ?: ""
                        eachItem.content = eachItem.content ?: ""
                        eachItem.urlToImage =
                            if (eachItem.urlToImage != null) eachItem.urlToImage else ApiEndpoints.IMAGE
                    }
                }
                DataState.Success(result!!)
            } else {
                DataState.Error("Data not available")
            }
        } catch (e: Exception) {
            DataState.Error("Data not available")
        }
    }
}