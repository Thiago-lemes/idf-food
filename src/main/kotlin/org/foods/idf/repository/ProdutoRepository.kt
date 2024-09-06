package org.foods.idf.repository

import org.foods.idf.entity.ProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository: JpaRepository<ProdutoEntity, Long> {
    fun findByNome(nome: String): ProdutoEntity?
}
