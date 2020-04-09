package com.example.youtubeplayer.videoDisplay

import android.os.Bundle
import com.example.youtubeplayer.Const
import com.example.youtubeplayer.R
import com.example.youtubeplayer.model.videosResultModel.Item
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video_display2.*

class VideoDisplayActivity : YouTubeBaseActivity() {

    lateinit var initializer: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_display2)

        val selectedVideo = intent.getParcelableExtra<Item>("selectedVideo")
        initializeYouTube(selectedVideo)
        youtubeViewPlayer.initialize(Const.ApiKey, initializer)

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
