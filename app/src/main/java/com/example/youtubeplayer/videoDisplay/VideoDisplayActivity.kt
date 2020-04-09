package com.example.youtubeplayer.videoDisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.youtubeplayer.Const
import com.example.youtubeplayer.R
import com.google.android.youtube.player.YouTubePlayerFragment
import com.google.android.youtube.player.YouTubePlayerSupportFragment

class VideoDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_display2)



        val youTubePlayerFragment = supportFragmentManager
            .findFragmentById(R.id.youtubeViewPlayer) as YouTubePlayerSupportFragment
        youTubePlayerFragment.initialize(Const.ApiKey, viewModel.initializer)

    }
}
