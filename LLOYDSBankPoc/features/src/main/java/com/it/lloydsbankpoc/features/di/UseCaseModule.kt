package com.it.lloydsbankpoc.features.di

import com.it.lloydsbankpoc.features.domain.repository.NewsRepository
import com.it.lloydsbankpoc.features.domain.repository.WorldNewsRepository
import com.it.lloydsbankpoc.features.domain.usecase.NewsUseCase
import com.it.lloydsbankpoc.features.domain.usecase.WorldNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesHeadlinesUseCase(repository: NewsRepository): NewsUseCase {
        return NewsUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesWorldNewsUseCase(repository: WorldNewsRepository): WorldNewsUseCase {
        return WorldNewsUseCase(repository)
    }
}