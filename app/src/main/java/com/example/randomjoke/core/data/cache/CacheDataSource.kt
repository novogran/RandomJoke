package com.example.randomjoke.core.data.cache

import com.example.randomjoke.core.data.ChangeStatus
import com.example.randomjoke.core.data.DataFetcher

interface CacheDataSource<E>: DataFetcher<E>, ChangeStatus<E>