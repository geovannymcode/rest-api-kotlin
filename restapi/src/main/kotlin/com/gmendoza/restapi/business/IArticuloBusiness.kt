package com.gmendoza.restapi.business

import com.gmendoza.restapi.model.Articulo

interface IArticuloBusiness {

    fun list(): List<Articulo>
    fun load(idArticulo:Long): Articulo
    fun save(articulo: Articulo): Articulo
    fun remove(idArticulo:Long)
}