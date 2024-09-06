package org.foods.idf.service

import org.foods.idf.DTO.CategoriaDTO
import org.foods.idf.entity.CategoriaEntity
import org.foods.idf.exception.CategoriaException
import org.foods.idf.repository.CategoriaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoriaService(private val repository: CategoriaRepository) {
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

    fun buscaCategorias(page: Int, size: Int): Page<CategoriaEntity> {
        val pageable: Pageable = PageRequest.of(page, size)
        return repository.findAll(pageable)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun buscaNome(nome: String): Optional<CategoriaEntity> {
        return repository.findByNome(nome)
    }
}