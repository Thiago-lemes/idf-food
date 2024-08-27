package org.foods.idf.repository

import org.foods.idf.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository: JpaRepository<Produto, Long> {}
