package com.example.youtubeplayer.channel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeplayer.Const
import com.example.youtubeplayer.model.videosResultModel.Item
import com.example.youtubeplayer.model.YoutubeResult
import com.example.youtubeplayer.network.YouTubeApi
import kotlinx.coroutines.*

class ChannelViewModel(youtubeResult: YoutubeResult) : ViewModel() {

    var channelId: String
    private val _selectedChannel = MutableLiveData<YoutubeResult>()
    val selectedChannel: LiveData<YoutubeResult>
        get() = _selectedChannel

    private val _VideoList = MutableLiveData<List<Item>>()
    val videoList: LiveData<List<Item>>
        get() = _VideoList


    val job = Job()
    val scope = CoroutineScope(job + Dispatchers.Main)

    init {
        _selectedChannel.value = youtubeResult
        channelId = youtubeResult.items!![0]!!.id
        getVideos()
    }

    private fun getVideos() {
        scope.launch {
                val call = YouTubeApi.retrofitServices.getChannelVideos(
                    Const.part,
                    Const.maxResults,
                    Const.ApiKey,
                    channelId
                )
                try {
                    _VideoList.value =  call.await().items

                } catch (e: Exception) {

                    Log.d("result " , "error${e.message}")

                }

        }
    }

    private val _navigateToSelectedVideo = MutableLiveData<Item>()
    val navigateToSelectedVideo : LiveData<Item>
    get() = _navigateToSelectedVideo

    fun displaySelectedVideo(selectedVideo : Item)
    {
        _navigateToSelectedVideo.value = selectedVideo
    }

    fun compeletSelectingVideo(){
        _navigateToSelectedVideo.value = null
    }


}