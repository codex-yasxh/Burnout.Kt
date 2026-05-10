package com.aditya.burnoutkt

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.aditya.burnoutkt.database.BurnoutDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = BurnoutDatabase.Schema,
            context = context,
            name = "burnout.db"
        )
}
