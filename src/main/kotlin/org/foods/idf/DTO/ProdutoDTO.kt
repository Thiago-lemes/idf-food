package org.foods.idf.DTO

import org.foods.idf.entity.Produto
import org.foods.idf.entity.StatusProduto
import java.time.LocalDateTime

data class ProdutoDTO(
    val nome: String,
    val descricao: String? = null,
    val preco: Double,
    val quantidade: Int,
//    val categoriaId: Long,
    val imagemUrl: String? = null,
    val dataCriacao: LocalDateTime? = null,
    val status: StatusProduto? = null
) {
    fun toProdutoEntity(): Produto {
        return Produto(
            nome = nome,
            descricao = descricao,
            preco = preco,
            quantidade = quantidade,
            dataCriacao = dataCriacao ?: LocalDateTime.now(),
            status = status ?: StatusProduto.DISPONIVEL,
            imagem = imagemUrl,
//            categoria = CategoriaEntity(id = categoriaId)
        )
    }
}
