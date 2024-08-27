package org.foods.idf.entity


import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "categoria")
data class CategoriaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nome: String = "",

    @Column
    val descricao: String? = null,

    @Column(nullable = false)
    val dataCriacao: LocalDateTime = LocalDateTime.now()
)
