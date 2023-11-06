package com.example.myapplication.data

import com.example.myapplication.model.Place

class MockRepository(private var data: MutableList<Place>) : EntryRepository {
    override fun getEntry(id: Int): Place {
        return data.first { it.id == id }
    }

    override fun getEntries(): List<Place> {
        return data.toList();
    }

    override fun getEntriesOrderedByScore(): List<Place> {
        return data.toList().sortedBy { it.score };
    }

    override fun saveEntry(entry: Place): Boolean {
        if ((data.find { it.id == entry.id }) == null) {
            data.add(entry)
            return true
        }
        return false
    }

    override fun deleteEntry(id: Int): Boolean {

        val entry = data.find { it.id == id }
        if (entry != null) {
            data.remove(entry)
            return true
        }
        return false
    }


    override fun replaceEntry(id: Int): Boolean {
        val entry = data.find { it.id == id }
        if (entry != null) {
            data.remove(entry)
            return true
        }
        return false

    }




}