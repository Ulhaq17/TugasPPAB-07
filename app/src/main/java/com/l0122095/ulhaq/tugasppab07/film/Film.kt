package com.l0122095.ulhaq.tugasppab07.film

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String,
    val year: String,
    val synopsys: String,
    val cover: Int
):Parcelable
