package org.foods.idf.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "pedido")
data class PedidoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    val usuario: UsuarioEntity,

    @Column(nullable = false)
    val dataPedido: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val status: StatusPedido = StatusPedido.PENDENTE,

    @Column(nullable = false)
    val valorTotal: Double
)

enum class StatusPedido {
    PENDENTE, PAGO, CANCELADO
}
