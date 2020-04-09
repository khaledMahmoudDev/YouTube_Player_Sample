package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    var contentDetails: ContentDetails? = null,
    var etag: String ="",
    var id: String ="",
    var kind: String ="",
    var snippet: Snippet ?=null,
    var statistics: Statistics? = null
):Parcelable
