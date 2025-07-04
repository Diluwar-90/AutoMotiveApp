package com.example.assignmentrle.notification

interface AlertNotifier {
    fun alertDriver(customerId: String, speed: Int)
}