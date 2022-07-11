package com.example.randomjoke.presentation


import android.app.Application
import com.example.randomjoke.NewCloudDataSource
import com.example.randomjoke.data.*
import com.example.randomjoke.data.cache.*
import com.example.randomjoke.data.mapper.JokeRealmMapper
import com.example.randomjoke.data.mapper.QuoteRealmMapper
import com.example.randomjoke.data.net.NewJokeService
import com.example.randomjoke.data.net.QuoteCloudDataSource
import com.example.randomjoke.data.net.QuoteService
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

        val realmProvider= BaseRealmProvide()
        val resourceManager = BaseResourceManager(this)
        val failureHandler = FailureFactory(resourceManager)
        val mapper = CommonSuccessMapper()
        val cacheDataSource = JokeCachedDataSource(realmProvider, JokeRealmMapper(), JokeRealmToCommonMapper())
        val cloudDataSource = NewCloudDataSource(retrofit.create(NewJokeService::class.java))
        val jokeRepository = BaseRepository(cacheDataSource,cloudDataSource, BaseCachedData())
        val interactor = BaseInteractor(jokeRepository,
            failureHandler, mapper
        )
        viewModel = BaseViewModel(interactor, BaseCommunication())

        val quoteRepository = BaseRepository(
            QuoteCachedDataSource(realmProvider, QuoteRealmMapper(), QuoteRealmToCommonMapper()),
            QuoteCloudDataSource(retrofit.create(QuoteService::class.java)),
            BaseCachedData()
        )
        quoteViewModel = BaseViewModel(
            BaseInteractor(quoteRepository, failureHandler, mapper),
            BaseCommunication())
    }
}