package com.example.youtubeplayer.channelList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeplayer.databinding.ChannelListItemBinding
import com.example.youtubeplayer.model.YoutubeResult

class ChannelListAdapter(private val channelClickListener: ChannelListClickListener) :
    ListAdapter<YoutubeResult, ChannelListAdapter.ChannelViewHolder>(ChannelDifUtill) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        return ChannelViewHolder(ChannelListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {

        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            channelClickListener.onClick(getItem(position))

        }

    }

    class ChannelViewHolder(private var binding: ChannelListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(youtubeResult: YoutubeResult) {
            binding.youtubeResult = youtubeResult
            binding.executePendingBindings()

        }
    }


    companion object ChannelDifUtill : DiffUtil.ItemCallback<YoutubeResult>() {
        override fun areItemsTheSame(
            oldItem: YoutubeResult,
            newItem: YoutubeResult
        ): Boolean {
            return oldItem.items!![0]!!.id == newItem.items!![0]!!.id
        }

        override fun areContentsTheSame(
            oldItem: YoutubeResult,
            newItem: YoutubeResult
        ): Boolean {
            return oldItem == newItem
        }
    }


    class ChannelListClickListener(val clickListener: (youtubeResult: YoutubeResult) -> Unit) {
        fun onClick(youtubeResult: YoutubeResult) =
            clickListener(youtubeResult)
    }


}