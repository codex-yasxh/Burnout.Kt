
package com.aditya.burnoutkt

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory{
    fun createDriver() : SqlDriver
}