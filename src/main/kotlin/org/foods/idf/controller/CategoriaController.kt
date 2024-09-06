package org.foods.idf.controller

import org.foods.idf.DTO.CategoriaDTO
import org.foods.idf.entity.CategoriaEntity
import org.foods.idf.service.CategoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("categoria")
class CategoriaController(
    @Autowired
    private val service: CategoriaService
) {
    @PostMapping("/nova-categoria")
    fun novaCategoria(@RequestBody dto: CategoriaDTO): ResponseEntity<CategoriaEntity> {
        val novaCategoria = service.novaCategoria(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<CategoriaEntity> {
        val dto = service.buscaCategoriaId(id)
        return ResponseEntity.ok(dto)
    }

    @GetMapping("/find-all")
    fun findAll(@RequestParam page: Int, @RequestParam size: Int): ResponseEntity<Page<CategoriaEntity>> {
        val categorias = service.buscaCategorias(page, size )
        return ResponseEntity.ok(categorias)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}