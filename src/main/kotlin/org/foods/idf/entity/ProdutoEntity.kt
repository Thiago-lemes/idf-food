package org.foods.idf.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "produto")
data class ProdutoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nome: String,

    @Column
    val descricao: String? = null,

    @Column(nullable = false)
    val preco: Double,

    @Column(nullable = false)
    val quantidade: Int,

    @Lob
    @Column(name = "imagem")
    val imagem: String? = null,

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    val categoria: CategoriaEntity,

    @Column(nullable = false)
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val status: StatusProduto = StatusProduto.DISPONIVEL
)

enum class StatusProduto {
    DISPONIVEL, INDISPONIVEL
}
