package com.example.assignmentrle.data

import com.example.assignmentrle.domain.model.Customer

class CustomerRepository {

    // Simulated in-memory customer database
    private val customerMap = mutableMapOf<String, Customer>()

    fun registerCustomer(customer: Customer) {
        customerMap[customer.id] = customer
    }

    fun getCustomer(customerId: String): Customer? {
        return customerMap[customerId]
    }
}