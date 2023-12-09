package com.example.myapplication.data

import com.example.Places

interface PlaceDataSource {

    fun getPlaceById(id: Long): Places?

    fun getAllPlaces(): List<Places>

    fun insertPlace(name: String, description: String, date: String, score: Long, locationId: Long, id: Long)


}