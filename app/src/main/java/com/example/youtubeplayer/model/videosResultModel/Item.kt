package com.example.youtubeplayer.model.videosResultModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val etag: String = "",
    val id: Id? = null,
    val kind: String = "",
    val snippet: Snippet? = null
) : Parcelable