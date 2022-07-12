package com.example.randomjoke.data

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.domain.CommonItem

class CommonSuccessMapper<E>: CommonDataModelMapper<CommonItem.Success, E> {
    override fun map(id: E, first: String, second: String, cached: Boolean) =
        CommonItem.Success(first,second,cached)
}