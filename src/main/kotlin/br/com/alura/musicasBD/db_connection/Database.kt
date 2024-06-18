package br.com.alura.musicasBD.db_connection

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Database {
    fun getEntityManager():EntityManager{
        val factory:EntityManagerFactory = Persistence.createEntityManagerFactory("screensound")
        return factory.createEntityManager()
    }
}