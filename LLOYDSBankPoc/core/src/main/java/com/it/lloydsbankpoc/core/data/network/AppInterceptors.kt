package com.it.lloydsbankpoc.core.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptors : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Authorization", "92114aa7e66b4ea0a646573dacff7fda")
            .build()
        return chain.proceed(request)
    }
}