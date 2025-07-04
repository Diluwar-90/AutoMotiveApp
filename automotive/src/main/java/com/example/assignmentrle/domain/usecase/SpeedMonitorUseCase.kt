package com.example.assignmentrle.domain.usecase

import com.example.assignmentrle.data.CustomerRepository
import com.example.assignmentrle.data.SpeedProvider
import com.example.assignmentrle.notification.AlertNotifier
import com.example.assignmentrle.notification.CompanyNotifier

class SpeedMonitorUseCase(
    private val customerRepo: CustomerRepository,
    private val speedProvider: SpeedProvider,
    private val companyNotifier: CompanyNotifier,
    private val alertNotifier: AlertNotifier
) {

    fun monitorSpeed(customerId: String) {
        val customer = customerRepo.getCustomer(customerId) ?: return
        val currentSpeed = speedProvider.getCurrentSpeed(customerId)

        if (currentSpeed > customer.maxSpeedLimit) {
            // Notify both parties
            alertNotifier.alertDriver(customerId, currentSpeed)

            try {
                companyNotifier.notifyCompany(customerId, currentSpeed)
            } catch (e: Exception) {
                companyNotifier.notifyViaAwsIfFirebaseFails(customerId, currentSpeed)
            }
        }
    }
}