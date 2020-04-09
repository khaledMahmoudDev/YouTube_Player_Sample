package com.example.youtubeplayer.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private val YOUTUBE_API_BASE_URL = "https://www.googleapis.com/"


val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(YOUTUBE_API_BASE_URL)
    .build()

object YouTubeApi{
    val retrofitServices : YouTubeApiServices by lazy {
        retrofit.create(YouTubeApiServices::class.java)
    }
}