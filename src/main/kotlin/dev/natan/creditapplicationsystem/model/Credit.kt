package dev.natan.creditapplicationsystem.model

import dev.natan.creditapplicationsystem.enumeration.CreditStatus
import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
data class Credit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) val id: Long? = null,
    @Column(nullable = false) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val firstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int = 0,
    @Column(nullable = false) @Enumerated val status: CreditStatus = CreditStatus.IN_PROGRESS,
    @JoinColumn(nullable = false) @ManyToOne val customer: Customer? = null
    )