package com.example.randomjoke.presentation


import android.app.Application
import com.example.randomjoke.CommonRealmMapper
import com.example.randomjoke.CommonSuccessMapper
import com.example.randomjoke.data.*
import com.example.randomjoke.domain.*
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp: Application() {

    lateinit var viewModel: BaseViewModel
    lateinit var quoteViewModel : BaseViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level  = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cacheDataSource = BaseCacheDataSource(BaseRealmProvide(), CommonRealmMapper())
        val resourceManager = BaseResourceManager(this)
        val cloudDataSource = NewCloudDataSource(retrofit.create(NewJokeService::class.java))
        val repository = BaseRepository(cacheDataSource,cloudDataSource,BaseCachedData())
        val interactor = BaseInteractor(repository,
            FailureFactory(resourceManager), CommonSuccessMapper()
        )
        viewModel = BaseViewModel(interactor, BaseCommunication())
        quoteViewModel = BaseViewModel(
            BaseInteractor(
                BaseRepository(
            object : CacheDataSource {
                override suspend fun getData(): CommonDataModel {
                    TODO("Not yet implemented")
                }

                override suspend fun addOrRemove(
                    id: Int,
                    joke: CommonDataModel
                ): CommonDataModel {
                    TODO("Not yet implemented")
                }
            },
                    object : CloudDataSource {
                        override suspend fun getData(): CommonDataModel {
                            TODO("Not yet implemented")
                        }
                    }, BaseCachedData()
            ), failureHandler, mapper
        ),BaseCommunication())
    }


}