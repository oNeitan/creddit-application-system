package dev.natan.creditapplicationsystem.service.impl

import dev.natan.creditapplicationsystem.model.Credit
import dev.natan.creditapplicationsystem.repository.CreditRepository
import dev.natan.creditapplicationsystem.service.ICreditService
import java.lang.RuntimeException
import java.util.*

class CreditService( private val repository: CreditRepository,
                     private val customerService: CustomerService): ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.repository.save(credit)
    }

    override fun findAllByCustomerId(customerId: Long): List<Credit> =
        this.repository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit = this.repository.findByCreditCode(creditCode) ?:
        throw RuntimeException("CreditCode $creditCode not found")

        return if(credit.customer?.id == customerId) credit
        else throw RuntimeException("CustomerID $customerId not found")
    }


}