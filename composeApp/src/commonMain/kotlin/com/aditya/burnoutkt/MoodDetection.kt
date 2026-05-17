package com.aditya.burnoutkt


fun detectMood(text: String): MoodSuggestion {
    return when {
        listOf("stressed", "stuck", "bug", "frustrated", "tired", "blocked")
            .any { text.contains(it, ignoreCase = true) } -> {
            MoodSuggestion.TakeABreak
        }

        listOf("working", "building", "coding", "implementing", "solving")
            .any { text.contains(it, ignoreCase = true) } -> {
            MoodSuggestion.DeepFocus
        }

        listOf("shipped", "done", "fixed", "completed", "finished","deployed")
            .any { text.contains(it, ignoreCase = true) } -> {
            MoodSuggestion.LogAndPlanNext
        }

        listOf("thinking", "idea", "exploring", "researching", "brainstorming")
            .any { text.contains(it, ignoreCase = true) } -> {
            MoodSuggestion.Ideate
        }

        else -> MoodSuggestion.TakeABreak // default to break when unsure
    }
}