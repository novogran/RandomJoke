package com.example.randomjoke

class TestCacheDataSource: CacheDataSource {

    private val map = HashMap<Int, Joke>()
    private var success: Boolean = true
    private var nextJokeIdToGet = -1

    override suspend fun addOrRemove(id: Int, joke: Joke): JokeUiModel {
        return if(map.containsKey(id)){
            val result = map[id]!!.toBaseJoke()
            map.remove(id)
            result
        } else {
            map[id] = joke
            joke.toFavoriteJoke()
        }
    }

    override suspend fun getJoke(): Result<Joke, Unit> {
        return if (success) {
            Result.Success(map[nextJokeIdToGet]!!)
        } else {
            Result.Error(Unit)
        }
    }


}