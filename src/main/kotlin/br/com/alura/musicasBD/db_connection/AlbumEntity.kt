package br.com.alura.musicasBD.db_connection

import br.com.alura.musicasBD.models.Band
import javax.persistence.*

@Entity
@Table(name = "albums")
class AlbumEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int = 0,
    val title:String = "N/A Title",
    @ManyToOne
    val band:BandEntity = BandEntity()
)