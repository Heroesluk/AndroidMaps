package com.example.myapplication.UI_logic

sealed class PlaceEvent {
    object RemovePlacePlaceEvent : PlaceEvent()
    data class SavePlace(
        val placeName: String, val placeDescription: String,
        val placeLocation: String,
        val placeScore: String, val placeEventData: String
    ) : PlaceEvent()


}