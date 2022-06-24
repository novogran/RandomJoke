package com.example.randomjoke

class BaseModel(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
    private val resourceManager: ResourceManager
): Model {

    private val noCachedJokes by lazy { NoCachedJokes(resourceManager) }
    private val noConnection by lazy { NoConnection(resourceManager) }
    private val serviceUnavailable by lazy { ServiceUnavailable(resourceManager) }

    private var jokeCallback: JokeCallback? = null
    private var cachedJoke: Joke? = null
    private var getJokeFromCache = false

    override fun getJoke() {
        if (getJokeFromCache) {
            cloudDataSource.getJoke(object : JokeCloudCallback {
                override fun provide(joke: Joke) {
                    cachedJoke = joke
                    jokeCallback?.provide(joke.toFavoriteJoke())
                }

                override fun fail(error: ErrorType) {
                    cachedJoke =  null
                    jokeCallback?.provide(FailedJoke(noCachedJokes.getMessage()))
                }
            })
        } else {
            cloudDataSource.getJoke(object :JokeCloudCallback{
                override fun provide(joke: Joke) {
                    cachedJoke = joke
                    jokeCallback?.provide(joke.toBaseJoke())
                }

                override fun fail(error: ErrorType) {
                    cachedJoke = null
                    val failure = if(error == ErrorType.NO_CONNECTION) noConnection else serviceUnavailable
                    jokeCallback?.provide(FailedJoke(failure.getMessage()))
                }

            })
        }
    }

    override fun init(callback: JokeCallback) {
        this.jokeCallback = callback
    }

    override fun clear() {
        jokeCallback = null
    }

    override fun changeJokeStatus(callback: JokeCallback) {
        cachedJoke?.let {
            jokeCallback?.provide(it.change(cacheDataSource))
        }
    }

    override fun chooseDataSource(cached: Boolean) {
        getJokeFromCache = cached
    }
}