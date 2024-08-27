package org.foods.idf.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "pagamento")
data class PagamentoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    val pedido: PedidoEntity,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val metodoPagamento: MetodoPagamento,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val statusPagamento: StatusPagamento = StatusPagamento.PENDENTE,

    @Column
    val dataPagamento: LocalDateTime? = null,

    @Column(nullable = false)
    val valorPago: Double
)

enum class MetodoPagamento {
    CARTAO, DINHEIRO, PIX
}

enum class StatusPagamento {
    PAGO, PENDENTE, FALHADO
}
