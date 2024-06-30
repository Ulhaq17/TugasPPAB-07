package com.l0122095.ulhaq.tugasppab07.book

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val title: String,
    val author: String,
    val synopsys: String,
    val cover: Int
):Parcelable
