package com.gmendoza.restapi.web

import com.gmendoza.restapi.business.IArticuloBusiness
import com.gmendoza.restapi.exception.BusinessException
import com.gmendoza.restapi.exception.NotFoundException
import com.gmendoza.restapi.model.Articulo
import com.gmendoza.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(Constants.URL_BASE_ARTICULOS)
class ArticuloRestController {

    @Autowired
    val articuloBusiness: IArticuloBusiness?=null

    @GetMapping("")
    fun list(): ResponseEntity<List<Articulo>> {
        return try {
            ResponseEntity(articuloBusiness!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idArticulo:Long): ResponseEntity<Articulo> {
        return try {
            ResponseEntity(articuloBusiness!!.load(idArticulo), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@Valid @RequestBody articulo: Articulo): ResponseEntity<Any> {
        return try {
            articuloBusiness!!.save(articulo)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_ARTICULOS + "/" + articulo.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody articulo: Articulo): ResponseEntity<Any> {
        return try {
            ResponseEntity(articuloBusiness!!.save(articulo), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idArticulo:Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(articuloBusiness!!.remove(idArticulo), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}