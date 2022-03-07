package com.gmendoza.restapi.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "articulo")
data class Articulo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @get: NotBlank
    val titulo: String = " ",

    @get: NotBlank
    val contenido: String = ""//,

    //@ManyToOne var autor: Persona
)
