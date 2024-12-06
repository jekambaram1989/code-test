package com.it.lloydsbankpoc.features.presentation.view.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.it.lloydsbankpoc.core.data.util.DataState
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.domain.usecase.NewsUseCase
import com.it.lloydsbankpoc.features.domain.usecase.WorldNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsViewmodelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val dispatcher = StandardTestDispatcher()

    private val testScope = TestScope(dispatcher)

    private lateinit var newsUseCase: NewsUseCase

    private lateinit var worldNewsUseCase: WorldNewsUseCase

    private lateinit var viewmodel: NewsViewmodel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        newsUseCase = mock(NewsUseCase::class.java)
        worldNewsUseCase = mock(WorldNewsUseCase::class.java)
        viewmodel = NewsViewmodel(newsUseCase, worldNewsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `get news initial return loading`() = testScope.runTest {
        `when`(newsUseCase("us")).thenReturn(DataState.Loading)
        viewmodel.getNews()
        advanceUntilIdle()
        Assert.assertEquals(DataState.Loading, viewmodel.news.value)
    }

    @Test
    fun `get news fetch from server return success list`() = testScope.runTest {
        val list = listOf(Article(), Article())
        `when`(newsUseCase("us")).thenReturn(DataState.Success(list))
        viewmodel.getNews()
        advanceUntilIdle()
        Assert.assertEquals(DataState.Success(list), viewmodel.news.value)
    }

    @Test
    fun `get news fetch from server return error message`() = testScope.runTest {
        val message = "Data not found"
        `when`(newsUseCase("us")).thenReturn(DataState.Error(message))
        viewmodel.getNews()
        advanceUntilIdle()
        Assert.assertEquals(DataState.Error<List<Article>>(message), viewmodel.news.value)
    }
}