package org.foods.idf.service

import org.foods.idf.DTO.ProdutoDTO
import org.foods.idf.entity.Produto
import org.springframework.stereotype.Service
import org.foods.idf.repository.ProdutoRepository

@Service
class ProdutoService(
    private val repository: ProdutoRepository,
) {
    fun cadastro(dto: ProdutoDTO): Produto {
            val produto = dto.toEntity()
            repository.save(produto)
            return produto
    }

}