package com.example.randomjoke

import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.core.domain.FailureHandler
import com.example.randomjoke.data.BaseRepository
import com.example.randomjoke.data.CommonSuccessMapper
import com.example.randomjoke.data.cache.BaseCachedData
import com.example.randomjoke.data.cache.JokeCachedDataSource
import com.example.randomjoke.data.cache.JokeRealmToCommonMapper
import com.example.randomjoke.data.mapper.JokeRealmMapper
import com.example.randomjoke.data.net.BaseJokeService
import com.example.randomjoke.data.net.JokeCloudDataSource
import com.example.randomjoke.domain.BaseInteractor
import com.example.randomjoke.presentation.BaseCommunication
import retrofit2.Retrofit

class JokesModule(
    private val failureHandler: FailureHandler,
    private val realmProvide: RealmProvider,
    private val retrofit: Retrofit
): BaseModel<Int,JokeViewModel>() {

    private var communication: BaseCommunication<Int>? = null

    override fun getViewModel(): JokeViewModel {
        return JokeViewModel(getInteractor(),getCommunications())
    }

    override fun getCommunications(): BaseCommunication<Int> {
        if(communication == null)
            communication = BaseCommunication()
        return communication!!

    }

    private fun getInteractor() =
        BaseInteractor(getRepository(),failureHandler,CommonSuccessMapper())
    private fun getRepository() =
        BaseRepository(getCacheDatasource(),getCloudDataSource(),BaseCachedData())
    private fun getCacheDatasource() =
        JokeCachedDataSource(realmProvide, JokeRealmMapper(), JokeRealmToCommonMapper())

    private fun getCloudDataSource() =
        JokeCloudDataSource(retrofit.create(BaseJokeService::class.java))
}