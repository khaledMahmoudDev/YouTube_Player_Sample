package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PageInfo(var resultsPerPage : Long = 0L, var totalResults : Long = 0L):Parcelable