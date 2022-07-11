package com.example.randomjoke.domain

import com.example.randomjoke.*
import java.lang.Exception

class BaseInteractor(
    private val repository: CommonRepository,
    private val failureHandler: FailureHandler,
    private val mapper: CommonDataModelMapper<CommonItem.Success>
): CommonInteractor {
    override suspend fun getJoke(): CommonItem {
        return try{
            repository.getCommonItem().map(mapper)
        } catch(e: Exception){
            CommonItem.Failed(failureHandler.handle(e))
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