package dev.natan.creditapplicationsystem.repository

import dev.natan.creditapplicationsystem.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID_CUSTOMER = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>

}