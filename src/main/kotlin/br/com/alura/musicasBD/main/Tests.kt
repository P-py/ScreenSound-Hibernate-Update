package br.com.alura.musicasBD.main

import br.com.alura.musicasBD.db_connection.AlbumsDAO
import br.com.alura.musicasBD.db_connection.BandsDAO
import br.com.alura.musicasBD.db_connection.Database
import br.com.alura.musicasBD.models.Album
import br.com.alura.musicasBD.models.Band
import java.util.*

val consoleInput = Scanner(System.`in`)
val dbManager = Database.getEntityManager()
val albumsDAO = AlbumsDAO(dbManager)
val bandsDAO = BandsDAO(dbManager)

fun main(){
    var bandsCounter = bandsDAO.getSize()
    var albumsCounter = albumsDAO.getSize()
    println("\n---TESTS CASE---")
    do{
        printMenu()
        val op = consoleInput.nextInt()
        when(op){
            1 -> viewDatabase()
            2 -> {
                if (bandsCounter==0){
                    println("\nYou should add a band before adding a album")
                } else {
                    addTestAlbum(albumsCounter, bandsCounter)
                    albumsCounter++
                }
            }
            3 ->{
                addTestBand(bandsCounter)
                bandsCounter++
            }
            4 ->{
                deleteAlbum()
                bandsCounter--
            }
            5 ->{
                deleteBand()
                albumsCounter--
            }
        }
    }while(op!=6)

}
fun addTestAlbum(counter:Int, counterBands:Int){
    val bandTest = bandsDAO.getById(counterBands)
    val albumTest = Album("Album test $counter", bandTest)
    albumsDAO.add(albumTest)
}
fun addTestBand(counter:Int){
    val bandTest = Band("Band test $counter", "Description default")
    bandsDAO.add(bandTest)
}
fun deleteBand(){
    print("ID: ")
    val id = consoleInput.nextInt()
    bandsDAO.deleteById(id)
}
fun deleteAlbum(){
    print("ID: ")
    val id = consoleInput.nextInt()
    albumsDAO.deleteById(id)
}
fun printMenu(){
    println("\n[1] View database")
    println("[2] Add test album")
    println("[3] Add test bands")
    println("[4] Delete album by id")
    println("[5] Delete band by id")
    print("->")
}
fun viewDatabase(){
    val listAlbums = albumsDAO.getList()
    val listBands = bandsDAO.getList()
    println("--- ALBUMS ---")
    listAlbums.forEach{
        println(it)
    }
    println("--- BANDS ---")
    listBands.forEach{
        println(it)
    }
}