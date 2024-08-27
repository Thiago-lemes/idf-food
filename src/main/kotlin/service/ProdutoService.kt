package service

import DTO.ProdutoDTO
import entity.Produto
import org.springframework.stereotype.Service
import repository.ProdutoRepository

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