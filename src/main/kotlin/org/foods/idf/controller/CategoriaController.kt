package org.foods.idf.controller

import org.foods.idf.DTO.CategoriaDTO
import org.foods.idf.entity.CategoriaEntity
import org.foods.idf.service.Categoria
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("categoria")
class CategoriaController (private val service: Categoria){
    @PostMapping("/nova-categoria")
    fun novaCategoria(@RequestBody dto: CategoriaDTO): ResponseEntity<CategoriaEntity> {
        val novaCategoria = service.novaCategoria(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria)
    }
}