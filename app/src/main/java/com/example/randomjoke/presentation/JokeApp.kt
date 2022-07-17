package com.example.randomjoke.presentation

import android.app.Application
import com.example.randomjoke.NewCloudDataSource
import com.example.randomjoke.data.BaseRepository
import com.example.randomjoke.data.CommonSuccessMapper
import com.example.randomjoke.data.cache.*
import com.example.randomjoke.data.mapper.JokeRealmMapper
import com.example.randomjoke.data.mapper.QuoteRealmMapper
import com.example.randomjoke.data.net.NewJokeService
import com.example.randomjoke.data.net.QuoteCloudDataSource
import com.example.randomjoke.data.net.QuoteService
import com.example.randomjoke.domain.BaseInteractor
import com.example.randomjoke.domain.FailureFactory
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JokeApp: Application() {

    lateinit var jokeViewModel: BaseViewModel<Int>
    lateinit var quoteViewModel : BaseViewModel<String>
    lateinit var jokeCommunication: BaseCommunication<Int>
    lateinit var quoteCommunication: BaseCommunication<String>

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
        val mapper = CommonSuccessMapper<Int>()
        val quoteMapper = CommonSuccessMapper<String>()
        val jokeCacheDataSource = JokeCachedDataSource(realmProvider, JokeRealmMapper(), JokeRealmToCommonMapper())
        val quoteCacheDataSource = QuoteCachedDataSource(realmProvider, QuoteRealmMapper(), QuoteRealmToCommonMapper())
        val jokeCloudDataSource = NewCloudDataSource(retrofit.create(NewJokeService::class.java))
        val quoteCloudDataSource = QuoteCloudDataSource(retrofit.create(QuoteService::class.java))
        val jokeRepository = BaseRepository(jokeCacheDataSource,jokeCloudDataSource,BaseCachedData<Int>())
        val quoteRepository = BaseRepository(quoteCacheDataSource,quoteCloudDataSource,BaseCachedData<String>())
        val jokeInteractor = BaseInteractor(jokeRepository,failureHandler, mapper)
        val quoteInteractor = BaseInteractor(quoteRepository, failureHandler, quoteMapper)
        jokeCommunication = BaseCommunication()
        quoteCommunication = BaseCommunication()
        jokeViewModel = BaseViewModel(jokeInteractor, jokeCommunication)
        quoteViewModel = BaseViewModel(quoteInteractor,quoteCommunication)
    }
}