package com.example.randomjoke.data

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.core.data.ChangeCommonItem
import com.example.randomjoke.core.data.ChangeStatus
import com.example.randomjoke.presentation.ShowText


class CommonDataModel<E> (
    private val id: E,
    private val firstText: String,
    private val secondText: String,
    private val cached: Boolean = false
): ChangeCommonItem<E> {

    fun map(showText: ShowText) = showText.show(firstText)

    fun <T> map(mapper: CommonDataModelMapper<T,E>):T {
        return mapper.map(id, firstText, secondText, cached)
    }

    override suspend fun change(changeStatus: ChangeStatus<E>) =
        changeStatus.addOrRemove(id,this)

    fun changeCached(cached: Boolean) =
        CommonDataModel(id, firstText, secondText, cached)
}
