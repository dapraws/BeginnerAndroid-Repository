package com.example.myarticleapp_kotlin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable
