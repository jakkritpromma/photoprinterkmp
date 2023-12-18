package com.example.photoprinterkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
