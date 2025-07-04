package com.example.assignmentrle

import com.example.assignmentrle.data.*
import com.example.assignmentrle.domain.model.Customer
import com.example.assignmentrle.domain.usecase.SpeedMonitorUseCase
import com.example.assignmentrle.notification.*
import com.example.assignmentrle.viewmodel.*

fun main() {
    val customerRepo = CustomerRepository()

    // Simulated Customer
    val customer = Customer(id = "cust001", name = "Diluwar Hossain", maxSpeedLimit = 80)
    customerRepo.registerCustomer(customer)

    val speedProvider = object : SpeedProvider {
        override fun getCurrentSpeed(customerId: String): Int {
            return 95 // Simulate a speed reading
        }
    }

    val companyNotifier = object : CompanyNotifier {
        override fun notifyCompany(customerId: String, speed: Int) {
            println("Firebase: Notifying company that $customerId drove at $speed km/h")
            // throw Exception("Firebase Failed") // Uncomment to test fallback
        }

        override fun notifyViaAwsIfFirebaseFails(customerId: String, speed: Int) {
            println("AWS Fallback: Notifying company that $customerId drove at $speed km/h")
        }
    }

    val alertNotifier = object : AlertNotifier {
        override fun alertDriver(customerId: String, speed: Int) {
            println("Warning sent to driver $customerId for exceeding speed: $speed km/h")
        }
    }

    val useCase = SpeedMonitorUseCase(customerRepo, speedProvider, companyNotifier, alertNotifier)
    val viewModel = SpeedMonitorViewModel(useCase)

    // Simulate speed update
    viewModel.onSpeedUpdate("cust001")
}
