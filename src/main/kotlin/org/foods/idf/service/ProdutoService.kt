package org.foods.idf.service

import org.foods.idf.DTO.ProdutoDTO
import org.foods.idf.entity.ProdutoEntity
import org.foods.idf.exception.CategoriaException
import org.foods.idf.repository.ProdutoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

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

    fun buscaCategoriaId(id: Long): ProdutoEntity {
        val entity = repository.findById(id).orElseThrow { IllegalArgumentException("ID invalido") }
        return entity
    }

    fun buscaProdutos(page: Int, size: Int): Page<ProdutoEntity> {
        val pageable: Pageable = PageRequest.of(page, size)
        return repository.findAll(pageable)
    }

    fun update(id: Long, dto: ProdutoDTO): ProdutoEntity {
        val produtoExistente = buscaCategoriaId(id)
        val produtoNome = dto.nome.trim().uppercase()
        val nome = buscaNome(produtoNome)
        if (nome.isPresent) {
            throw CategoriaException("ERRO: Categoria já existe ${nome.get()}")
        }
        val categoria = categoriaService.buscaCategoriaId(dto.categoriaId)
        val produtoAtualizado = produtoExistente.copy(
            nome = produtoNome,
            descricao = dto.descricao,
            preco = dto.preco,
            quantidade = dto.quantidade,
            dataCriacao = dto.dataCriacao
                ?: produtoExistente.dataCriacao, // Mantém a data de criação existente se não for passada
            status = dto.status ?: produtoExistente.status, // Mantém o status atual se não for passado
            imagem = dto.imagemUrl,
            categoria = categoria
        )
        return repository.save(produtoAtualizado)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun buscaNome(nome: String): Optional<ProdutoEntity> {
        return repository.findByNome(nome)
    }
}