package com.example.youtubeplayer.channel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeplayer.model.YoutubeResult

class ChannelDisplayViewModelFactory(private val youtubeResult: YoutubeResult) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChannelViewModel::class.java)) {
            return ChannelViewModel(youtubeResult) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}