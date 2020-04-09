package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Snippet(
    var country: String = "",
    var customUrl: String = "",
    var description: String ="",
    var localized: Localized? = null,
    var publishedAt: String ="",
    var thumbnails: Thumbnails?=null,
    var title: String = ""
):Parcelable