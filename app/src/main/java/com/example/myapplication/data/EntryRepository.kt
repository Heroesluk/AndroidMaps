package com.example.myapplication.data

import com.example.myapplication.model.Place

interface EntryRepository {

    fun getEntry(id: Int): Place;
    fun getEntries(): List<Place>;
    fun getEntriesOrderedByScore(): List<Place>;

    fun saveEntry(entry: Place): Boolean;
    fun deleteEntry(id: Int): Boolean;
    fun replaceEntry(id: Int): Boolean;

}