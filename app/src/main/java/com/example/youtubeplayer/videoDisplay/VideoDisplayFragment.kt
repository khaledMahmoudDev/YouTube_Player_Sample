package com.example.youtubeplayer.videoDisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.youtubeplayer.Const
import com.example.youtubeplayer.R
import com.example.youtubeplayer.databinding.FragmentVideoDisplayBinding
import com.google.android.youtube.player.YouTubePlayerFragment
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.fragment_video_display.*


class VideoDisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentVideoDisplayBinding.inflate(inflater)
        val selctedVideo = VideoDisplayFragmentArgs.fromBundle(arguments!!).selectedVideo
        binding.lifecycleOwner = this

        val viewModelFactory = VideoDisplayViewModelFactory(selctedVideo)
        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(VideoDisplayViewModel::class.java)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val youTubePlayerFragment = fragmentManager
            ?.findFragmentById(R.id.youtubeView) as YouTubePlayerSupportFragment


    }

}