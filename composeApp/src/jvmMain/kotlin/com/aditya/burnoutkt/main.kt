package com.aditya.burnoutkt

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.material3.MaterialTheme

fun main() = application { // Compose Desktop's entry point, kind of setContent in Android's main activity
    val viewModel = AppModule.provideViewModel(
        DatabaseDriverFactory()
    )

    Window( //creates an actual OS window for desktop like with title and X , - and maximize button
        onCloseRequest = ::exitApplication, // the exit button
        title = "Burnout.kt"
    ) {
        MaterialTheme {
            JournalScreen(viewModel = viewModel)
        }
    }
}