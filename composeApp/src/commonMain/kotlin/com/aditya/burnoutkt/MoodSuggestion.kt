package com.aditya.burnoutkt

sealed class MoodSuggestion(val displayText: String) {
    object TakeABreak : MoodSuggestion("Take a break")
    object DeepFocus : MoodSuggestion("Deep focus")
    object LogAndPlanNext : MoodSuggestion("Log it + plan next")
    object Ideate : MoodSuggestion("Ideate")
}