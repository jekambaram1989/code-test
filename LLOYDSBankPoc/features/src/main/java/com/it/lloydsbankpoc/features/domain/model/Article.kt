package com.it.lloydsbankpoc.features.domain.model

data class Article(
    val source: Source? = null,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    val url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
)
