package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.Places
import com.example.myapplication.data.PlaceDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlaceListViewModel @Inject constructor(
    private val personDataSource: PlaceDataSource
) : ViewModel() {


    fun temp(): Places? {
        personDataSource.insertPlace("Eiffel", "works", "oki", 1, 2, 3)
        var place = personDataSource.getPlaceById(3);
        return place
    }


}