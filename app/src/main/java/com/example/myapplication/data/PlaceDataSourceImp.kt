package com.example.myapplication.data

import com.example.Database
import com.example.Places

class PlaceDataSourceImp(
    db: Database
) : PlaceDataSource {

    private val queries = db.databaseQueries;
    override fun getPlaceById(id: Long): Places? {

        return queries.getPlaceById(id).executeAsOneOrNull();

    }

    override fun getAllPlaces(): List<Places> {
        return queries.getPlaces().executeAsList()
    }

    override fun insertPlace(
        name: String,
        description: String,
        date: String,
        score: Long,
        locationId: Long,
        id: Long
    ) {
        queries.insertPlace(id, name, description, date, score, locationId)
    }
}