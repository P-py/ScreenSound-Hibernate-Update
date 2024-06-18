package br.com.alura.musicasBD.db_connection

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    private val dbManager:EntityManager,
    private val entityType:Class<TEntity>)
{
    abstract fun toEntity(originalObject:TModel):TEntity
    abstract fun toModel(originalEntity:TEntity):TModel
    open fun getSize():Int{
        return getList().size
    }
    open fun add(newObject:TModel){
        val entity = toEntity(newObject)
        dbManager.transaction.begin()
        dbManager.persist(entity)
        dbManager.transaction.commit()
    }
    open fun deleteById(id:Int){
        val query = dbManager.createQuery("FROM ${entityType.simpleName} WHERE id = :id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        dbManager.transaction.begin()
        dbManager.remove(entity)
        dbManager.transaction.commit()
    }
    open fun getById(id:Int):TModel{
        val query = dbManager.createQuery("FROM ${entityType.simpleName} WHERE id = :id", entityType)
        query.setParameter("id", id)
        return toModel(query.singleResult)
    }
    open fun getList():List<TModel>{
        //For example
        //val query = dbManager.createQuery("FROM GameEntity", GameEntity::class.java)
        val query = dbManager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map{
            entity -> toModel(entity)
        }
    }
}