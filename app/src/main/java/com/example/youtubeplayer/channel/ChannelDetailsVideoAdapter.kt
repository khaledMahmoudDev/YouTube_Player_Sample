package com.example.youtubeplayer.channel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeplayer.databinding.VideosListItemBinding
import com.example.youtubeplayer.model.videosResultModel.Item

class ChannelDetailsVideoAdapter(private val clisckListener: VideosClickListener) :
    ListAdapter<Item, ChannelDetailsVideoAdapter.VideosViewoHolder>(VideosDifUtill) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewoHolder {
        return VideosViewoHolder(VideosListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VideosViewoHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clisckListener.onClick(getItem(position))
        }
    }


    class VideosViewoHolder(private var binding: VideosListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {

            binding.videoResult = item
            binding.executePendingBindings()

        }

    }

    companion object VideosDifUtill : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    class VideosClickListener(val clickListener: (item: Item) -> Unit) {
        fun onClick(item: Item) = clickListener(item)

    }


}