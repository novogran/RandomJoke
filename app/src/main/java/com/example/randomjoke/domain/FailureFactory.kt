package com.example.randomjoke.domain

import com.example.randomjoke.GenericError
import com.example.randomjoke.NoCachedData
import com.example.randomjoke.NoConnection
import com.example.randomjoke.ServiceUnavailable
import com.example.randomjoke.core.ResourceManager
import com.example.randomjoke.core.domain.FailureHandler
import com.example.randomjoke.core.domain.NoCachedDataException
import com.example.randomjoke.core.domain.NoConnectionException
import com.example.randomjoke.core.domain.ServiceUnavailableException


class FailureFactory(private val resourceManager: ResourceManager): FailureHandler {
    override fun handle(e: Exception) =
        when (e){
            is NoConnectionException -> NoConnection(resourceManager)
            is NoCachedDataException -> NoCachedData(resourceManager)
            is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
            else -> GenericError(resourceManager)
        }
    }
