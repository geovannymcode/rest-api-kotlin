package com.gmendoza.restapi.business

import com.gmendoza.restapi.dao.ArticuloRepository
import com.gmendoza.restapi.exception.BusinessException
import com.gmendoza.restapi.exception.NotFoundException
import com.gmendoza.restapi.model.Articulo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticuloBusiness: IArticuloBusiness {

    @Autowired
    val articuloRepository: ArticuloRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Articulo> {
        try {
            return articuloRepository!!.findAll()
        }catch (e:Exception)
        {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idArticulo: Long): Articulo {
        val op: Optional<Articulo>
        try {
            op= articuloRepository!!.findById(idArticulo)
        }catch (e:Exception)
        {
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se encontro el articulo con el id $idArticulo")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(articulo: Articulo): Articulo {
        try {
            return articuloRepository!!.save(articulo)
        }catch (e:Exception)
        {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idArticulo: Long) {
        val op: Optional<Articulo>
        try {
            op= articuloRepository!!.findById(idArticulo)
        }catch (e:Exception)
        {
            throw BusinessException(e.message)
        }
        if(!op.isPresent) {
            throw NotFoundException("No se encontro el articulo con el id $idArticulo")
        }else{
            try{
                articuloRepository!!.deleteById(idArticulo)
            }catch (e:Exception)
            {
                throw BusinessException(e.message)
            }
        }
    }
}