package org.foods.idf.DTO

import org.foods.idf.entity.CategoriaEntity

data class CategoriaDTO(
    val nome: String,
    val descricao: String,
){
   fun toCategoriaProduto(): CategoriaEntity{
       return CategoriaEntity(
           nome = nome,
           descricao = descricao,
       )
   }
}
