package com.it.lloydsbankpoc.core.data.util

sealed class DataState<out T> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error<T>(val message: String) : DataState<T>()
    object Loading : DataState<Nothing>()
}