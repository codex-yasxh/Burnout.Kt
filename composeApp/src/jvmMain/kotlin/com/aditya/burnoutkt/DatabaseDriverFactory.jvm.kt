package com.aditya.burnoutkt

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import app.cash.sqldelight.db.SqlDriver
import com.aditya.burnoutkt.database.BurnoutDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also {
            BurnoutDatabase.Schema.create(it)
        }
}