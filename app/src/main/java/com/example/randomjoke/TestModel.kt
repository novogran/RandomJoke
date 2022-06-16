package com.example.randomjoke

class TestModel(resourceManager: ResourceManager): Model {

    private var callback : ResultCallback? = null
    private var count = 0
    private val noConnection = NoConnection(resourceManager)
    private val serviceUnavailable = ServiceUnavailable(resourceManager)

    override fun getJoke() {
        Thread {
            Thread.sleep(1000)
            when(count){
                1 ->  callback?.provideSuccess(Joke("testText","testPunchline"))
                2 ->  callback?.provideError(noConnection)
                3 -> callback?.provideError(serviceUnavailable)
            }
            count++
            if(count == 3) count = 0
        }.start()
    }

    override fun init(callback: ResultCallback) {
        this.callback = callback
    }

    override fun clear() {
        callback = null
    }
}