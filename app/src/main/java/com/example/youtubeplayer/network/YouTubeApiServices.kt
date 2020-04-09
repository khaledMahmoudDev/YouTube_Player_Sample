package com.example.youtubeplayer.network

import com.example.youtubeplayer.model.videosResultModel.VideosResult
import com.example.youtubeplayer.model.YoutubeResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiServices {

    @GET("/youtube/v3/channels")
    fun getChannel(
        @Query("part") part: String,
        @Query("part") part2: String,
        @Query("part") part3: String,
        @Query("key") key: String,
        @Query("id") id: String
    ): Deferred<YoutubeResult>

    @GET("/youtube/v3/search")
    fun getChannelVideos(
        @Query("part") part: String,
        @Query("maxResults") maxResult: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String
    ): Deferred<VideosResult>

}