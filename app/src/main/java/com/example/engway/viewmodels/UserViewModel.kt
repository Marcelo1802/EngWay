package com.example.livekoin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livekoin.api.UserAPI
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class YouTubeViewModel : ViewModel(), KoinComponent {

    private val userAPI: UserAPI by inject()

    fun searchVideos(query: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = userAPI.searchVideos("snippet", query, apiKey)
                // Trate a resposta conforme necessário
                response.items.forEach {
                    println("Title: ${it.snippet.title}")
                    println("Description: ${it.snippet.description}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}