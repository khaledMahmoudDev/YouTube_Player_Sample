package com.example.youtubeplayer.channelList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeplayer.Const
import com.example.youtubeplayer.model.YoutubeResult
import com.example.youtubeplayer.network.YouTubeApi
import kotlinx.coroutines.*

class ChannelListViewModel : ViewModel() {
    val testChannels = listOf<String>(
        "UCfnY3c7YoAUQij96FfFW9jw",
        "UCmeqakSoEdmxEtTnCFSbunw",
        "UCrNtUy4sBJ2rGB4QS4FmgRA",
        "UCKDpgAqxLXCt9tJwWaZS8CQ",
        "UC_x5XG1OV2P6uZZ5FSM9Ttw"
    )

    private val _chennelList = MutableLiveData<List<YoutubeResult>>()
    val channelList: LiveData<List<YoutubeResult>>
        get() = _chennelList


    val job = Job()

    val channelViewModelScope = CoroutineScope(job + Dispatchers.Main)


    init {
        gettwo()
    }

    fun gettwo() {
        channelViewModelScope.launch {

            val channelResultList = ArrayList<YoutubeResult>()
            withContext(Dispatchers.IO)
            {
                testChannels.forEach { i ->
                    val res = YouTubeApi.retrofitServices.getChannel(
                        Const.part,
                        Const.part1,
                        Const.part2,
                        Const.ApiKey,
                        i
                    )
                    channelResultList.add(res.await())
                }
            }

            _chennelList.value = channelResultList


        }
    }



    private val _navigateToChannelDetail = MutableLiveData<YoutubeResult>()
    val navigateToChannelDetail : LiveData<YoutubeResult>
    get() = _navigateToChannelDetail


    fun displayChannelDetail(youtubeResult: YoutubeResult)
    {
        _navigateToChannelDetail.value = youtubeResult
    }

    fun completeNavigateToChannelDetail(){
        _navigateToChannelDetail.value = null
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}