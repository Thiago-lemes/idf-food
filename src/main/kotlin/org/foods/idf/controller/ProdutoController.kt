package org.foods.idf.controller

import org.foods.idf.DTO.ProdutoDTO
import org.foods.idf.entity.Produto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.foods.idf.service.ProdutoService

@RestController
@RequestMapping("/produtos")
class ProdutoController(private val service: ProdutoService) {
    @PostMapping("/cadastro-novo-produto")
    fun cadastro(@RequestBody dto: ProdutoDTO): ResponseEntity<Produto>{
        val produtoCriado = service.cadastro(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado)
    }
}
