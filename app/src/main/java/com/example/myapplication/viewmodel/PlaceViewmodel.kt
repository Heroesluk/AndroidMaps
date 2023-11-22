package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.Screen

class PlaceViewmodel : ViewModel() {
    var navController: NavHostController? = null;

    var textPlace by mutableStateOf("Create place")
        private set

    var placeName by mutableStateOf("")
    var placeDescription by mutableStateOf("")
    var placeLocation by mutableStateOf("")

    var placeRating by mutableStateOf("")
    var placeEventDate by mutableStateOf("")


    fun changeText() {
        textPlace = "Dziala"
    }

    fun onChangePlaceName(name: String) {
        placeName = name
    }

    fun onChangeDescription(description: String) {
        placeDescription = description
    }

    fun onChangeLocation(location: String) {
        placeLocation = location
    }

    fun onRatingChange(rating: String) {
        placeRating = rating

    }

    fun submitPlace() {
        navController!!.navigate(Screen.DisplayPlaces.route)

    }

    fun setNav(navControllerPassed: NavHostController) {
        navController = navControllerPassed;
    }


}
