package com.example.youtubeplayer.channelList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.youtubeplayer.databinding.FragmentChannelListBinding

class ChannelListFragment : Fragment() {
    private val viewModel: ChannelListViewModel by lazy {
        ViewModelProviders.of(this).get(ChannelListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentChannelListBinding.inflate(inflater)
        binding.lifecycleOwner = this


        binding.viewModel = viewModel

        binding.channelListRecycler.adapter =
            ChannelListAdapter(ChannelListAdapter.ChannelListClickListener {
                viewModel.displayChannelDetail(it)

            })


        viewModel.navigateToChannelDetail.observe(viewLifecycleOwner, Observer {
            if (null != it)
            {
                this.findNavController().navigate(ChannelListFragmentDirections.actionChannelListFragmentToChannelFragment(it))
                viewModel.completeNavigateToChannelDetail()
            }

        })

        return binding.root
    }
}