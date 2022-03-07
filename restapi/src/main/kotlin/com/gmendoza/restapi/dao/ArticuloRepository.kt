package com.gmendoza.restapi.dao

import com.gmendoza.restapi.model.Articulo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticuloRepository: JpaRepository<Articulo, Long> {

}