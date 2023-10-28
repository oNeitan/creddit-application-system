package dev.natan.creditapplicationsystem.service

import dev.natan.creditapplicationsystem.model.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}