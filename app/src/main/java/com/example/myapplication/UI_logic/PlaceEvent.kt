package com.example.myapplication.UI_logic

sealed class PlaceEvent {
    object RemovePlacePlaceEvent : PlaceEvent()
    data class SavePlace(val name: String): PlaceEvent()


}