package org.foods.idf.repository

import org.foods.idf.entity.CategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CategoriaRepository: JpaRepository<CategoriaEntity, Long> {
    fun findByNome(nome: String): Optional<CategoriaEntity>
}