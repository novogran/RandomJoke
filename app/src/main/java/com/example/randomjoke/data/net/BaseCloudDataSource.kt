package com.example.randomjoke.data.net

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.core.data.net.CloudDataSource
import com.example.randomjoke.core.domain.NoConnectionException
import com.example.randomjoke.core.domain.ServiceUnavailableException
import com.example.randomjoke.data.CommonDataModel
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