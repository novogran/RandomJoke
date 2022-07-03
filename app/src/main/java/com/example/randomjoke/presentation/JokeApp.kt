package com.example.randomjoke.presentation


import android.app.Application
import com.example.randomjoke.domain.BaseResourceManager
import com.example.randomjoke.JokeRealmMapper
import com.example.randomjoke.JokeSuccessMapper
import com.example.randomjoke.data.*
import com.example.randomjoke.domain.BaseJokeInteractor
import com.example.randomjoke.domain.BaseJokeRepository
import com.example.randomjoke.domain.JokeFailureFactory
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp: Application() {

    lateinit var viewModel: BaseViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cacheDataSource = BaseCacheDataSource(BaseRealmProvide(), JokeRealmMapper())
        val resourceManager = BaseResourceManager(this)
        val cloudDataSource = BaseCloudDataSource(retrofit.create(JokeService::class.java))
        val repository = BaseJokeRepository(cacheDataSource,cloudDataSource,BaseCachedJoke())
        val interactor = BaseJokeInteractor(repository,
            JokeFailureFactory(resourceManager), JokeSuccessMapper()
        )
        viewModel = BaseViewModel(interactor, BaseCommunication())
    }


}