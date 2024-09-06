package org.foods.idf.controller

import org.foods.idf.DTO.ProdutoDTO
import org.foods.idf.entity.ProdutoEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.foods.idf.service.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    @Autowired
    private val service: ProdutoService
) {
    @PostMapping("/cadastro-novo-produto")
    fun create(@RequestBody dto: ProdutoDTO): ResponseEntity<ProdutoEntity> {
        val produtoCriado = service.cadastro(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado)
    }

    @GetMapping("/find-all")
    fun findAll(@RequestParam page: Int, @RequestParam size: Int): ResponseEntity<Page<ProdutoEntity>> {
        val produtos = service.buscaProdutos(page, size)
        return ResponseEntity.ok(produtos)
    }

    @PutMapping("/{id}")
    fun atualizarProduto(@PathVariable id: Long, @RequestBody dto: ProdutoDTO): ResponseEntity<ProdutoEntity> {
        val produtoAtualizado = service.update(id, dto)
        return ResponseEntity.ok(produtoAtualizado)
    }
}
