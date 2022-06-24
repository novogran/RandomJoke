package com.example.randomjoke

data class Joke(
    private val id: Int,
    private val  type: String,
    private val  text: String,
    private val  punchline: String,
) {
    fun toBaseJoke() = BaseJokeUiModel(text,punchline)

    fun change(cacheDataSource: CacheDataSource) = cacheDataSource.addOrRemove(id,this)

    fun toFavoriteJoke() = FavoriteJokeUiModel(text,punchline)
}