package org.foods.idf.service

import org.foods.idf.DTO.ProdutoDTO
import org.foods.idf.entity.Produto
import org.foods.idf.repository.CategoriaRepository
import org.springframework.stereotype.Service
import org.foods.idf.repository.ProdutoRepository
import org.springframework.dao.DataIntegrityViolationException

@Service
class ProdutoService(
    private val repository: ProdutoRepository,
    private val categoriaService: Categoria
) {
    fun cadastro(dto: ProdutoDTO): Produto {
        try {
            val produtoNome = dto.nome.trim().uppercase()
            repository.findByNome(produtoNome)?.let {
                throw IllegalArgumentException("Produto com o nome '${dto.nome}' já existe.")
            }
            val categoriaId = categoriaService.buscaCategoriaId(dto.categoriaId)
            val produto = repository.save(dto.toProdutoEntity().copy(categoria = categoriaId, nome = produtoNome))
            return produto
        } catch (ex: DataIntegrityViolationException) {
            throw IllegalArgumentException("Produto com o nome '${dto.nome}' já existe.")
        }
    }

}