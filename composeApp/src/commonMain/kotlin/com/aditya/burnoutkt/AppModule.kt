package com.aditya.burnoutkt

import androidx.lifecycle.ViewModel
import com.aditya.burnoutkt.database.BurnoutDatabase

object AppModule{
    fun provideViewModel(factory: DatabaseDriverFactory): JournalViewModel{
        val driver = factory.createDriver()
        val database = BurnoutDatabase(driver)
        val repository = JournalRepository(database)
        return JournalViewModel(repository)
    }
}