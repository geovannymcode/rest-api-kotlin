package com.gmendoza.restapi.business

import com.gmendoza.restapi.model.Persona

interface IPersonaBusiness {

    fun list(): List<Persona>
    fun load(idPersona:Long): Persona
    fun save(persona:Persona): Persona
    fun remove(idPersona:Long)
}