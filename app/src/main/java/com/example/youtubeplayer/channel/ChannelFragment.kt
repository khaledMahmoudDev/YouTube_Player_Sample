package com.example.youtubeplayer.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.youtubeplayer.databinding.FragmentChannelDisplayBinding
import com.example.youtubeplayer.videoDisplay.VideoDisplayFragment

class ChannelFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChannelDisplayBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val youtubeResult = ChannelFragmentArgs.fromBundle(arguments!!).selectedChannel

        val viewModelFactory = ChannelDisplayViewModelFactory(youtubeResult)

        val viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ChannelViewModel::class.java)

        binding.channelViewModel = viewModel

        binding.recyclerViewDisplayChannel.adapter =
            ChannelDetailsVideoAdapter(ChannelDetailsVideoAdapter.VideosClickListener {
                viewModel.displaySelectedVideo(it)
            })

        viewModel.navigateToSelectedVideo.observe(viewLifecycleOwner, Observer {
            if (null != it)
            {
                this.findNavController().navigate(ChannelFragmentDirections.actionChannelFragmentToVideoDisplayFragment(it))
                viewModel.compeletSelectingVideo()
            }
        })


        return binding.root
    }

}