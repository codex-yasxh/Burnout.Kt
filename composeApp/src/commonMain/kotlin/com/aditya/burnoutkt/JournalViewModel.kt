package com.aditya.burnoutkt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.burnoutkt.database.JournalEntry
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

//So ViewModel's full job: not give me data, but when data changes, basically reactive
//1. Hold a StateFlow that UI observes
//2. Call Repository to get/save data
//3. Update the StateFlow when data changes

class JournalViewModel (
    private val repository: JournalRepository
) : ViewModel() {
    val entries: StateFlow<List<JournalEntry>> = repository.getAllEntries()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addEntry(text: String, mood: String){
        viewModelScope.launch {
            repository.insertEntry(text, mood)
        }
    }
}