package com.example.youtubeplayer.model.videosResultModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Snippet(
    val channelId: String = "",
    val channelTitle : String = "",
    val description : String = "",
    val liveBroadcastContent :String = "",
    val publishedAt : String = "",
    val thumbnails : Thumbnails ? = null,
    val title : String = ""
) : Parcelable