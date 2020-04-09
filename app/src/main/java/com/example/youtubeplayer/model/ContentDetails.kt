package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentDetails(var relatedPlaylists: RelatedPlaylists? = null):Parcelable