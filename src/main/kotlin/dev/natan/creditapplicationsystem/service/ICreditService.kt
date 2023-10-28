package dev.natan.creditapplicationsystem.service

import dev.natan.creditapplicationsystem.model.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
}