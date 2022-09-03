package com.example.uniton4.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RandomWorryEntity(
    val contents: String,
    val imgUrl: String,
    val worrySeq: Int,
    val nickname: String
): Parcelable
