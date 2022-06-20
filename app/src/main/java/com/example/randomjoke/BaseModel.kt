package com.example.randomjoke

class BaseModel(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
    private val resourceManager: ResourceManager
): Model {
    private val noConnection by lazy { NoConnection(resourceManager) }
    private val serviceUnavailable by lazy { ServiceUnavailable(resourceManager) }

    private var jokeCallback: JokeCallback? = null

    private var cachedJokeServerModel: JokeServerModel? = null
    private var getJokeFromCache = false

    override fun getJoke() {
        if (getJokeFromCache) {
            cloudDataSource.getJoke(object : JokeCloudCallback {
                override fun provide(jokeServerModel: JokeServerModel) {
                    cachedJokeServerModel = jokeServerModel
                    jokeCallback?.provide(jokeServerModel.toFavoriteJoke())
                }

                override fun fail() {
                    cachedJokeServerModel =  null
                    //jokeCallback?.provide(FailedJoke(noCachedJokes.getMessage()))
                    jokeCallback?.provide(FailedJoke(""))
                }
            })
        } else {
            cloudDataSource.getJoke(object :JokeCloudCallback{
                override fun provide(jokeServerModel: JokeServerModel) {
                }

                override fun fail() {
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
        cachedJokeServerModel?.change(cacheDataSource)?.let {
            jokeCallback?.provide(it)
        }
    }

    override fun chooseDataSource(cached: Boolean) {
        getJokeFromCache = cached
    }
}