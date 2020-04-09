package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class YoutubeResult(
    var etag: String = "",
    var items: List<Item?>? = null,
    var kind: String = "",
    var pageInfo: PageInfo?  = null
) : Parcelable