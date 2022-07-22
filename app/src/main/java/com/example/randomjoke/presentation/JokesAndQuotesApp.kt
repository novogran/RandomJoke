package com.example.randomjoke.presentation

import android.app.Application
import com.example.randomjoke.*
import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.core.domain.FailureHandler
import com.example.randomjoke.data.cache.*
import com.example.randomjoke.domain.FailureFactory
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JokesAndQuotesApp: Application() {

    val viewModelsFactory by lazy {
        ViewModelsFactory(
            MainModule(persistentDataSource),
            JokesModule(failureHandler, realmProvider, retrofit),
            QuotesModule(failureHandler, realmProvider, retrofit)
        )
    }

    private lateinit var retrofit: Retrofit
    private lateinit var realmProvider: RealmProvider
    private lateinit var failureHandler: FailureHandler
    private lateinit var persistentDataSource: PersistentDataSource

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
        failureHandler = FailureFactory(BaseResourceManager(this))
        persistentDataSource = PersistentDataSource.Base(this)
    }
}