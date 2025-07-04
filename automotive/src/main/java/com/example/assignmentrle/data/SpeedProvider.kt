package com.example.assignmentrle.data

interface SpeedProvider {
    fun getCurrentSpeed(customerId: String): Int
}