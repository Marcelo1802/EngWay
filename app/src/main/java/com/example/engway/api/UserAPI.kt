package com.example.livekoin.api


import com.example.engway.model.YouTubeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPI {
    @GET("search")
    suspend fun searchVideos(
        @Query("part") part: String,
        @Query("q") query: String,
        @Query("key") apiKey: String,
        @Query("type") type: String = "video"
    ): YouTubeResponse
}