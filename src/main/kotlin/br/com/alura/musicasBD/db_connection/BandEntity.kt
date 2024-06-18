package br.com.alura.musicasBD.db_connection

import javax.persistence.*

@Entity
@Table(name = "bands")
class BandEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int = 0,
    val name:String = "N/A Name",
    val description:String = "N/A Description"
)