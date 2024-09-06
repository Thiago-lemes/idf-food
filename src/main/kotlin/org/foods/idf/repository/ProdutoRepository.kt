package org.foods.idf.repository

import org.foods.idf.entity.ProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProdutoRepository: JpaRepository<ProdutoEntity, Long> {
    fun findByNome(nome: String): Optional<ProdutoEntity>
}
