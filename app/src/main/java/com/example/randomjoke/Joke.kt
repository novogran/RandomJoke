package com.example.randomjoke

data class Joke(
    private val id: Int,
    private val  type: String,
    private val  text: String,
    private val  punchline: String,
) {
    fun toBaseJoke() = BaseJokeUiModel(text,punchline)

    suspend fun change(cacheDataSource: CacheDataSource) = cacheDataSource.addOrRemove(id,this)

    fun toFavoriteJoke() = FavoriteJokeUiModel(text,punchline)

    fun toJokeRealm(): JokeRealm{
        return JokeRealm().also {
            it.id = id
            it.type = type
            it.text = text
            it.punchline = punchline
        }
    }
}