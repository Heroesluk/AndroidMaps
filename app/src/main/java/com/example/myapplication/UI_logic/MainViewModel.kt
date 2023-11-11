package com.example.myapplication.UI_logic

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.data.MockRepository
import com.example.myapplication.data.numbers
import com.example.myapplication.model.Location
import com.example.myapplication.model.Place
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {


    private val placeRepository = MockRepository(numbers)
    private val _state = mutableStateOf(PlacesState())
    val state = _state
    var navController: NavHostController? = null;

    init {
        getPlaces()
    }


    fun getPlaces() {
        viewModelScope.launch {
            val entries = placeRepository.getEntries()
            _state.value = _state.value.copy(places = entries)

        }
    }

    fun setNav(navControllerPassed: NavHostController) {
        navController = navControllerPassed;
    }


    fun onEvent(placeEvent: PlaceEvent) {
        when (placeEvent) {
            is PlaceEvent.RemovePlacePlaceEvent -> {
                viewModelScope.launch {
                    placeRepository.deleteEntry(0);
                    getPlaces()
                }
            }
            // if id = -1 to dodaj inaczej edytuj
            is PlaceEvent.SavePlace -> {

                placeRepository.saveEntry(
                    Place(
                        10,
                        placeEvent.placeName,
                        placeEvent.placeDescription,
                        placeEvent.placeEventData,
                        placeEvent.placeScore.toInt(),
                        Location(0, placeEvent.placeLocation),
                        R.drawable.ramen

                    )
                )
                getPlaces()

            }

            is PlaceEvent.EditPlace -> {

            }

            else -> {
            }
        }
    }
}

