package com.example.randomjoke.presentation

import android.app.Application
import com.example.randomjoke.JokesModule
import com.example.randomjoke.QuotesModule
import com.example.randomjoke.ViewModelsFactory
import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.core.domain.FailureHandler
import com.example.randomjoke.data.cache.*
import com.example.randomjoke.domain.FailureFactory
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JokeApp: Application() {

    val viewModelsFactory by lazy {
        ViewModelsFactory(
            JokesModule(failureHandler, realmProvider, retrofit),
            QuotesModule(failureHandler, realmProvider, retrofit)
        )
    }

    private lateinit var retrofit: Retrofit
    private lateinit var realmProvider: RealmProvider
    private lateinit var failureHandler: FailureHandler

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level  = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        realmProvider= BaseRealmProvide()
        val resourceManager = BaseResourceManager(this)
        failureHandler = FailureFactory(resourceManager)
    }
}