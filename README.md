# Burnout.kt 🔥

A developer journal app built with **Kotlin Multiplatform (KMP)** that detects your mood from journal entries and suggests what to do next — deep focus, take a break, ideate, or plan next.

Runs on **Android** and **Desktop JVM** from a single shared codebase.

---

## Why this exists

Most KMP demos share a string. This shares:
- A real SQLite database (SQLDelight)
- Business logic (Repository pattern)
- ViewModel with reactive StateFlow
- AI mood detection engine
- Compose UI

Zero duplicated logic between platforms.

---

## Architecture

```
commonMain
│
├── JournalScreen (Compose Multiplatform)
│         ↓
├── JournalViewModel (StateFlow)
│         ↓
├── JournalRepository
│         ↓
├── BurnoutDatabase (SQLDelight)
│         ↓
└── DatabaseDriverFactory (expect)
          ↙            ↘
    androidMain       jvmMain
AndroidSqliteDriver  JdbcSqliteDriver
```
---

## Mood Detection Engine

Pure Kotlin. No ML library. No API. No internet dependency.

| Keywords detected | Suggestion |
|---|---|
| stuck, bug, frustrated, stressed | Take a break 🛑 |
| working, building, coding | Deep focus 🎯 |
| shipped, done, fixed, completed | Log it + plan next ✅ |
| thinking, idea, exploring | Ideate 💡 |

Runs entirely in `commonMain` — same logic on both platforms.

---

## Stack

| Tool | Purpose |
|---|---|
| Kotlin Multiplatform | Shared logic across platforms |
| Compose Multiplatform | Shared UI across platforms |
| SQLDelight | Typesafe shared database |
| kotlinx.coroutines | Async data flow |
| AndroidSqliteDriver | Android DB driver |
| JdbcSqliteDriver | Desktop DB driver |

---

## KMP Concepts Demonstrated

- `expect/actual` — platform specific DB drivers
- `commonMain` shared ViewModel + Repository
- SQLDelight multiplatform database
- Compose Multiplatform shared UI
- Reactive StateFlow data pipeline

---

## Run it

**Android:**
Open in Android Studio → Run on emulator or device

**Desktop:**
```bash
./gradlew :composeApp:run
```

---

## Project Structure

```
composeApp/
├── commonMain/
│   ├── MoodDetector.kt
│   ├── MoodSuggestion.kt
│   ├── JournalRepository.kt
│   ├── JournalViewModel.kt
│   ├── AppModule.kt
│   ├── JournalScreen.kt
│   └── sqldelight/
│       └── JournalEntry.sq
├── androidMain/
│   ├── MainActivity.kt
│   └── DatabaseDriverFactory.android.kt
└── jvmMain/
    ├── main.kt
    └── DatabaseDriverFactory.jvm.kt
```
---
