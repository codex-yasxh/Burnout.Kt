package com.aditya.burnoutkt

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.material3.MaterialTheme

fun main() = application {
    val viewModel = AppModule.provideViewModel(
        DatabaseDriverFactory()
    )

    Window(
        onCloseRequest = ::exitApplication,
        title = "Burnout.kt"
    ) {
        MaterialTheme {
            JournalScreen(viewModel = viewModel)
        }
    }
}