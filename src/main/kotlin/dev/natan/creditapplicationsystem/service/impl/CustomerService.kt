package dev.natan.creditapplicationsystem.service.impl

import dev.natan.creditapplicationsystem.model.Customer
import dev.natan.creditapplicationsystem.repository.CustomerRepository
import dev.natan.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService( private val repository: CustomerRepository ): ICustomerService {

    override fun save(customer: Customer): Customer = this.repository.save(customer)

    override fun findById(id: Long): Customer = this.repository.findById(id).orElseThrow{
        throw RuntimeException("id $id not found") }

    override fun delete(id: Long) = this.repository.deleteById(id)

}