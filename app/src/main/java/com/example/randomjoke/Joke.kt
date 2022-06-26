package com.example.randomjoke

class Joke(
    private val id: Int,
    private val  type: String,
    private val  text: String,
    private val  punchline: String,
): ChangeJoke {
    fun toBaseJoke() = BaseJokeUiModel(text,punchline)

    override suspend fun change(changeJokeStatus: ChangeJokeStatus) =
        changeJokeStatus.addOrRemove(id,this)

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