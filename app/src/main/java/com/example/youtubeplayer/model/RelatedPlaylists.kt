package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelatedPlaylists(var uploads: String = "", var watchHistory: String = "", var watchLater: String =""):Parcelable