package com.example.randomjoke

class TestCacheDataSource: CacheDataSource {

    private val list = ArrayList<Pair<Int, JokeServerModel>>()

    override fun addOrRemove(id: Int, jokeServerModel: JokeServerModel): Joke {
        val found = list.find { it.first == id }
        return if (found != null) {
            val joke = found.second.toBaseJoke()
            list.remove(found)
            joke
        } else {
            list.add(Pair(id,jokeServerModel))
            jokeServerModel.toFavoriteJoke()
        }
    }

    override fun getJoke(jokeCachedCallback: JokeCachedCallback) {
        if(list.isEmpty())
            jokeCachedCallback.fail()
        else
            jokeCachedCallback.provide(list.random().second)
    }
}