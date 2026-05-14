package com.aditya.burnoutkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = AppModule.provideViewModel(
            DatabaseDriverFactory(this)
        )

        setContent {
            MaterialTheme {
                JournalScreen(viewModel = viewModel)
            }
        }
    }
}