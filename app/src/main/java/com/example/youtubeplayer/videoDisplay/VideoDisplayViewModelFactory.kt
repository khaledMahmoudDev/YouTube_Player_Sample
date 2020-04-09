package com.example.youtubeplayer.videoDisplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeplayer.model.videosResultModel.Item

class VideoDisplayViewModelFactory(private val selectedVideo: Item) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoDisplayViewModel::class.java)) {
            return VideoDisplayViewModel(selectedVideo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}