package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel
import java.lang.IllegalStateException

interface ChangeCommonItem {
    suspend fun change(changeStatus: ChangeStatus): CommonDataModel

    class Empty : ChangeCommonItem {
        override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
            throw IllegalStateException("empty change item called")
        }
    }
}