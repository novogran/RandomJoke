package com.example.randomjoke.data

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.domain.CommonItem

class CommonSuccessMapper: CommonDataModelMapper<CommonItem.Success> {
    override fun map(id: Int, first: String, second: String, cached: Boolean) =
        CommonItem.Success(first,second,cached)
}