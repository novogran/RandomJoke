package com.example.randomjoke

import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.core.domain.FailureHandler
import com.example.randomjoke.data.BaseRepository
import com.example.randomjoke.data.CommonSuccessMapper
import com.example.randomjoke.data.cache.BaseCachedData
import com.example.randomjoke.data.cache.QuoteCachedDataSource
import com.example.randomjoke.data.cache.QuoteRealmToCommonMapper
import com.example.randomjoke.data.mapper.QuoteRealmMapper
import com.example.randomjoke.data.net.QuoteCloudDataSource
import com.example.randomjoke.data.net.QuoteService
import com.example.randomjoke.domain.BaseInteractor
import com.example.randomjoke.presentation.BaseCommunication
import retrofit2.Retrofit

class QuotesModule(
    private val failureHandler: FailureHandler,
    private val realmProvider: RealmProvider,
    private val retrofit: Retrofit
) : Module.Base<String, QuoteViewModel>() {

    private var communication: BaseCommunication<String>? = null

    override fun getViewModel() = QuoteViewModel(getInteractor(), getCommunications())

    override fun getCommunications(): BaseCommunication<String> {
        if(communication == null)
            communication = BaseCommunication()
        return communication!!
    }

    private fun getInteractor() = BaseInteractor(getRepository(),failureHandler,CommonSuccessMapper())

    private fun getRepository() = BaseRepository(getCacheDataSource(),getCloudDataSource(),BaseCachedData())

    private fun getCacheDataSource() = QuoteCachedDataSource(realmProvider, QuoteRealmMapper(),
        QuoteRealmToCommonMapper()
    )

    private fun getCloudDataSource() = QuoteCloudDataSource(retrofit.create(QuoteService::class.java))


}