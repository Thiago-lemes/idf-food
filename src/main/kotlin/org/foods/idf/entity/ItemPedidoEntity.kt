package org.foods.idf.entity

import jakarta.persistence.*

@Entity
@Table(name = "ItemPedido")
data class ItemPedidoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    val pedido: PedidoEntity,

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    val produtoEntity: ProdutoEntity,

    @Column(nullable = false)
    val quantidade: Int,

    @Column(nullable = false)
    val precoUnitario: Double,

    @Column(nullable = false)
    val total: Double
)
