package com.aditya.burnoutkt

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.aditya.burnoutkt.database.BurnoutDatabase
import com.aditya.burnoutkt.database.JournalEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow



class JournalRepository(private val database: BurnoutDatabase){
    fun getAllEntries() : Flow<List<JournalEntry>> = database.journalEntryQueries
        .getAllEntries()
        .asFlow()
        .mapToList(Dispatchers.Default)

    suspend fun insertEntry(text: String, mood: String){
        database.journalEntryQueries
            .insertEntry(
                text = text,
                timestamp = System.currentTimeMillis(),
                mood = mood
            )
    }
}