package org.foods.idf.service

import org.foods.idf.DTO.CategoriaDTO
import org.foods.idf.entity.CategoriaEntity
import org.foods.idf.exception.CategoriaException
import org.foods.idf.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class Categoria(private val repository: CategoriaRepository) {
    fun novaCategoria(dto: CategoriaDTO): CategoriaEntity {
        val categoria = dto.nome.trim().uppercase()
        val nome = repository.findByNome(categoria)
        if (nome.isPresent) {
            throw CategoriaException("ERRO: Categoria já existe ${nome.get()}")
        }
        val novaCategoria = repository.save(dto.toCategoriaProduto().copy(nome = categoria))
        return novaCategoria
    }
}