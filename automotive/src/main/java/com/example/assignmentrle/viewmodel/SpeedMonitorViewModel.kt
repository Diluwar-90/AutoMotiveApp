package com.example.assignmentrle.viewmodel

import com.example.assignmentrle.domain.usecase.SpeedMonitorUseCase

class SpeedMonitorViewModel(
    private val useCase: SpeedMonitorUseCase
) {
    fun onSpeedUpdate(customerId: String) {
        useCase.monitorSpeed(customerId)
    }
}