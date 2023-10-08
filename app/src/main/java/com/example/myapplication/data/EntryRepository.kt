package com.example.myapplication.data

import com.example.myapplication.model.Entry

interface EntryRepository {

    fun getEntry(id: Int): Entry;
    fun getEntries(): List<Entry>;
    fun getEntriesOrderedByScore(): List<Entry>;

    fun saveEntry(entry: Entry): Boolean;
    fun deleteEntry(id: Int): Boolean;
    fun replaceEntry(id: Int): Boolean;

}