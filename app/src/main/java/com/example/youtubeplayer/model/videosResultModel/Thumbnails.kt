package com.example.youtubeplayer.model.videosResultModel

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Thumbnails(
    @Json(name = "default")
    var small: Default? = null,
    var high: High? = null,
    var medium: Medium? = null
): Parcelable