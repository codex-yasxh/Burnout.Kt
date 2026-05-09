package com.aditya.burnoutkt

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform