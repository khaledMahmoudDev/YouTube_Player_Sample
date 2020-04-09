package com.example.youtubeplayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Localized(
    var description: String = "",
    var title: String = ""
):Parcelable