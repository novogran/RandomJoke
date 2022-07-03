package com.example.randomjoke.domain

import com.example.randomjoke.*
import java.lang.Exception

class BaseJokeInteractor(
    private val repository: JokeRepository,
    private val jokeFailureHandler: JokeFailureHandler,
    private val mapper: JokeDataModelMapper<Joke.Success>
): JokeInteractor {
    override suspend fun getJoke(): Joke {
        return try{
            repository.getJoke().map(mapper)
        } catch(e: Exception){
            Joke.Failed(jokeFailureHandler.handle(e))
            }
        }

    override suspend fun changeFavorites(): Joke {
        return try {
            repository.changeJokeStatus().map(mapper)
        } catch (e: Exception) {
            Joke.Failed(jokeFailureHandler.handle(e))
        }
    }

    override fun getFavorites(favorites: Boolean) {
        repository.chooseDataSource(favorites)
    }
}