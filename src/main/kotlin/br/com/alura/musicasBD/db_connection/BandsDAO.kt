package br.com.alura.musicasBD.db_connection

import br.com.alura.musicasBD.extensions.toEntity
import br.com.alura.musicasBD.extensions.toModel
import br.com.alura.musicasBD.models.Band
import javax.persistence.EntityManager

class BandsDAO(dbManager:EntityManager):DAO<Band, BandEntity>(dbManager, BandEntity::class.java) {
    override fun toEntity(originalObject:Band):BandEntity {
        return originalObject.toEntity()
    }
    override fun toModel(originalEntity:BandEntity): Band {
        return originalEntity.toModel()
    }
}