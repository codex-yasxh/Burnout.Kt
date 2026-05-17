package com.aditya.burnoutkt

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.burnoutkt.database.JournalEntry

@Composable
fun JournalScreen(viewModel: JournalViewModel) {

    val entries by viewModel.entries.collectAsState()
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Burnout.kt",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("What did you work on?") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (text.isNotBlank()) {
                    // 1. Detect the mood based on the current text
                    val detectedMood = detectMood(text)

                    // 2. Pass the detected mood to your viewModel
                    // Assuming your MoodSuggestion is an Enum, use .name to save as String
                    viewModel.addEntry(text, detectedMood.displayText)

                    // 3. Clear the text field
                    text = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Entry")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Past Entries",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(entries) { entry ->
                EntryCard(entry)
            }
        }
    }
}

@Composable
fun EntryCard(entry: JournalEntry) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = entry.text,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = entry.mood,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}