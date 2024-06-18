package br.com.alura.musicasBD.extensions

import br.com.alura.musicasBD.db_connection.AlbumEntity
import br.com.alura.musicasBD.models.Album

fun Album.toEntity():AlbumEntity {
    return AlbumEntity(this.id, this.title, this.band.toEntity())
}

fun AlbumEntity.toModel(): Album {
    return Album(this.title, this.band.toModel(), this.id)
}