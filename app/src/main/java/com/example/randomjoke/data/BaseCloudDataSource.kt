package com.example.randomjoke.data

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.domain.NoConnectionException
import com.example.randomjoke.domain.ServiceUnavailableException
import retrofit2.Call
import java.lang.Exception
import java.net.UnknownHostException

abstract class BaseCloudDataSource<T: Mapper<CommonDataModel>>: CloudDataSource {

    protected abstract fun getServerModel(): Call<T>

    override suspend fun getData(): CommonDataModel {
        try {
            return getServerModel().execute().body()!!.to()
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }
}