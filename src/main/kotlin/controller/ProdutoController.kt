package controller

import DTO.ProdutoDTO
import entity.Produto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import service.ProdutoService

@RestController
@RequestMapping("/produtos")
class ProdutoController(private val service: ProdutoService) {
    @PostMapping("/cadastro-novo-produto")
    fun cadastro(@RequestBody dto: ProdutoDTO): ResponseEntity<Produto>{
        val produtoCriado = service.cadastro(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado)
    }
}
