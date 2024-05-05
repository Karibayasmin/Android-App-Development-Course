package com.kariba.photoalbum.network

import com.google.gson.Gson
import com.google.gson.internal.GsonBuildConfig
import com.kariba.photoalbum.Utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var retrofit : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}