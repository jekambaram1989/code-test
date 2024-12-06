package com.it.lloydsbankpoc.features.domain.usecase

import com.it.lloydsbankpoc.core.data.network.ApiEndpoints
import com.it.lloydsbankpoc.core.data.util.DataState
import com.it.lloydsbankpoc.features.domain.model.WorldNews
import com.it.lloydsbankpoc.features.domain.repository.WorldNewsRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WorldNewsUseCase @Inject constructor(private val repository: WorldNewsRepository) {

    private val categories =
        listOf("business", "Entertainment", "technology")

    suspend operator fun invoke(): DataState<List<WorldNews>> {
        return try {
            val list = mutableListOf<WorldNews>()
            categories.forEach { category ->
                val result = repository.getWorldNews(category)
                if (result.isSuccessful) {
                    val successData = result.body()!!
                    successData.country = category.replaceFirstChar(Char::titlecase)
                    list.add(successData)
                } else {
                    DataState.Error<List<WorldNews>>("Data not available")
                }
            }
            val newsCategories = list.onEach { news ->
                news.articles.filter { filterItem ->
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
            DataState.Success(newsCategories)
        } catch (e: Exception) {
            DataState.Error("Data not available")
        }
    }
}