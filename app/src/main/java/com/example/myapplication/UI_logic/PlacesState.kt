package com.example.myapplication.UI_logic

import com.example.myapplication.model.Place

data class PlacesState(
    val places: List<Place> = emptyList(),
)