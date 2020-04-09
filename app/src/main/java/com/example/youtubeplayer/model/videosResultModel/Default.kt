package com.example.youtubeplayer.model.videosResultModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Default(var height: Long = 0L, var url: String = "", var width: Long = 0L): Parcelable