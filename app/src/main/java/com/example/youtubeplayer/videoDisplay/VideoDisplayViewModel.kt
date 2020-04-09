package com.example.youtubeplayer.videoDisplay

import androidx.lifecycle.ViewModel
import com.example.youtubeplayer.model.videosResultModel.Item
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class VideoDisplayViewModel(private val selectedVideo : Item) : ViewModel() {




    lateinit var initializer  : YouTubePlayer.OnInitializedListener

    init {

        initializeYouTube(selectedVideo)
    }

    private fun initializeYouTube(selectedVideoItem: Item) {

        initializer = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1!!.loadVideo(selectedVideoItem.id!!.videoId)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                TODO("Not yet implemented")
            }

        }
    }
}