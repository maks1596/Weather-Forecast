package com.dataart.search.data.impl

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()

        val injectedUrl = originalUrl.newBuilder()
            .addQueryParameter("appid", BuildConfig.OPEN_WEATHER_API_KEY)
            .build()
        val injectedRequest = originalRequest.newBuilder()
            .url(injectedUrl)
            .build()

        return chain.proceed(injectedRequest)
    }
}