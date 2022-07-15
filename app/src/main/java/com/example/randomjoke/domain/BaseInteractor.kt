package com.example.randomjoke.domain

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.core.data.CommonRepository
import com.example.randomjoke.core.domain.CommonInteractor
import com.example.randomjoke.core.domain.FailureHandler
import kotlin.Exception

class BaseInteractor<E>(
    private val repository: CommonRepository<E>,
    private val failureHandler: FailureHandler,
    private val mapper: CommonDataModelMapper<CommonItem.Success,E>
): CommonInteractor {
    override suspend fun getItem(): CommonItem {
        return try{
            repository.getCommonItem().map(mapper)
        } catch(e: Exception){
            CommonItem.Failed(failureHandler.handle(e))
            }
        }

    override suspend fun getItemList(): List<CommonItem> {
        return try{
            repository.getCommonItemList().map {
                it.map(mapper)
            }
        } catch (e: Exception){
            listOf(CommonItem.Failed(failureHandler.handle(e)))
        }
    }

    override suspend fun changeFavorites(): CommonItem {
        return try {
            repository.changeStatus().map(mapper)
        } catch (e: Exception) {
            CommonItem.Failed(failureHandler.handle(e))
        }
    }

    override fun getFavorites(favorites: Boolean) {
        repository.chooseDataSource(favorites)
    }
}