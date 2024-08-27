package org.foods.idf.service

import org.foods.idf.DTO.CategoriaDTO
import org.foods.idf.entity.CategoriaEntity
import org.foods.idf.exception.CategoriaException
import org.foods.idf.repository.CategoriaRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class Categoria(private val repository: CategoriaRepository) {
    fun novaCategoria(dto: CategoriaDTO): CategoriaEntity {
        val categoria = dto.nome.trim().uppercase()
        val nome = buscaNome(categoria)
        if (nome.isPresent) {
            throw CategoriaException("ERRO: Categoria já existe ${nome.get()}")
        }
        val novaCategoria = repository.save(dto.toCategoriaProduto().copy(nome = categoria))
        return novaCategoria
    }

    fun buscaCategoriaId(id: Long): CategoriaEntity {
        val entity = repository.findById(id).orElseThrow { IllegalArgumentException("ID invalido") }
        return entity
    }

    fun buscaTodasCategorias(): List<CategoriaEntity> {
        return repository.findAll()
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun buscaNome(nome: String): Optional<CategoriaEntity> {
        return repository.findByNome(nome)
    }
}