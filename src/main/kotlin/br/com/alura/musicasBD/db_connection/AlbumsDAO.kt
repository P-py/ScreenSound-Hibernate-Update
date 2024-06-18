package br.com.alura.musicasBD.db_connection

import br.com.alura.musicasBD.extensions.toEntity
import br.com.alura.musicasBD.extensions.toModel
import br.com.alura.musicasBD.models.Album
import javax.persistence.EntityManager

class AlbumsDAO(dbManager: EntityManager):DAO<Album, AlbumEntity>(dbManager, AlbumEntity::class.java) {
    override fun toEntity(originalObject:Album):AlbumEntity {
        return originalObject.toEntity()
    }
    override fun toModel(originalEntity:AlbumEntity):Album {
        return originalEntity.toModel()
    }
}