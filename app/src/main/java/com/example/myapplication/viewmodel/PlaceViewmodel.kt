package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PlaceViewmodel: ViewModel() {
    var textPlace by mutableStateOf("Ok")
        private set

    fun changeText() {
        textPlace = "Dziala"
    }
}