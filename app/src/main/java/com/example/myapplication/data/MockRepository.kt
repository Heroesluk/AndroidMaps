package com.example.myapplication.data

import com.example.myapplication.model.Entry

class MockRepository(data: MutableList<Entry>) : EntryRepository {
    private var data: MutableList<Entry> = mutableListOf();
    override fun getEntry(id: Int): Entry {
        return data.first { it.id == id }
    }

    override fun getEntries(): List<Entry> {
        return data.toList();
    }

    override fun getEntriesOrderedByScore(): List<Entry> {
        return data.toList().sortedBy { it.score };
    }

    override fun saveEntry(entry: Entry): Boolean {
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