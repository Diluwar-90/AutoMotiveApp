package com.example.assignmentrle.notification

interface CompanyNotifier {
    fun notifyCompany(customerId: String, speed: Int)

    // fallback option
    fun notifyViaAwsIfFirebaseFails(customerId: String, speed: Int)
}