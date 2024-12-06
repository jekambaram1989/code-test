package com.it.lloydsbankpoc.features.domain.model

data class WorldNews(
    val status: String,
    val totalResults: Long,
    val articles: List<Article>,
    var country: String
)