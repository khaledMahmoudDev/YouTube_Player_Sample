package com.example.youtubeplayer

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.youtubeplayer.channel.ChannelDetailsVideoAdapter
import com.example.youtubeplayer.channelList.ChannelListAdapter
import com.example.youtubeplayer.model.videosResultModel.Item
import com.example.youtubeplayer.model.YoutubeResult

@BindingAdapter("ChannelListData")
fun bindChannelList(recyclerView: RecyclerView, data : List<YoutubeResult>?){
    val adapter = recyclerView.adapter as ChannelListAdapter
    adapter.submitList(data)

}

@BindingAdapter("videoListData")
fun bindVideolList(recyclerView: RecyclerView, data : List<Item>?){
    val adapter = recyclerView.adapter as ChannelDetailsVideoAdapter
    adapter.submitList(data)

}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }

}

@BindingAdapter("textTitle")
fun bindText(textView : TextView, data:String)
{
    textView.text = data

}