package com.example.youtubeplayer.model.videosResultModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideosResult(
    val etag: String = "",
    val items: List<Item>? = null,
    val kind: String = "",
    val nextPageToken: String = "",
    val pageInfo: PageInfo? = null,
    val regionCode: String = ""
) : Parcelable