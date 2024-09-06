package org.foods.idf.service

import org.foods.idf.DTO.ProdutoDTO
import org.foods.idf.entity.ProdutoEntity
import org.springframework.stereotype.Service
import org.foods.idf.repository.ProdutoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

@Service
class ProdutoService(
    private val repository: ProdutoRepository,
    private val categoriaService: CategoriaService
) {
    fun cadastro(dto: ProdutoDTO): ProdutoEntity {
            val produtoNome = dto.nome.trim().uppercase()
            repository.findByNome(produtoNome)?.let {
                throw IllegalArgumentException("Produto com o nome '${dto.nome}' já existe.")
            }
            val categoriaId = categoriaService.buscaCategoriaId(dto.categoriaId)
            val produto = repository.save(dto.toProdutoEntity().copy(categoria = categoriaId, nome = produtoNome))
            return produto
    }

    fun buscaProdutos(page: Int, size: Int): Page<ProdutoEntity> {
        val pageable: Pageable = PageRequest.of(page, size)
        return repository.findAll(pageable)
    }
}