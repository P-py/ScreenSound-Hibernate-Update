package br.com.alura.musicasBD.extensions

import br.com.alura.musicasBD.db_connection.BandEntity
import br.com.alura.musicasBD.models.Band

fun Band.toEntity():BandEntity {
    return BandEntity(this.id, this.name, this.description)
}

fun BandEntity.toModel(): Band {
    return Band(this.name, this.description, this.id)
}
