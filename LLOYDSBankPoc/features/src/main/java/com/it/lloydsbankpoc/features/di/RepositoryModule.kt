package com.it.lloydsbankpoc.features.di

import com.it.lloydsbankpoc.features.data.network.ApiService
import com.it.lloydsbankpoc.features.data.repository.NewsRepositoryImpl
import com.it.lloydsbankpoc.features.data.repository.WorldNewsRepositoryImpl
import com.it.lloydsbankpoc.features.domain.repository.NewsRepository
import com.it.lloydsbankpoc.features.domain.repository.WorldNewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesHeadlinesRepository(apiService: ApiService): NewsRepository {
        return NewsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesWorldNewsRepository(apiService: ApiService): WorldNewsRepository {
        return WorldNewsRepositoryImpl(apiService)
    }
}