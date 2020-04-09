package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Statistics(
    var commentCount: String ="",
    var hiddenSubscriberCount: Boolean = false,
    var subscriberCount: String = "",
    var videoCount: String ="",
    var viewCount: String = ""
):Parcelable