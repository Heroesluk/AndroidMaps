package com.example.myapplication.model

import androidx.annotation.DrawableRes

data class Entry(
    val id: Int,
    val name: String,
    val description: String,
    val date: String,
    val score: Int,
    val place: Place,
    @DrawableRes val imageId: Int
    )

data class Place(
    val id: Int,
    val coordinates: String
    // tbd
)

// can be either a date in past/future or a "future" value
