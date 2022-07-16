package com.example.randomjoke.domain

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.core.presentation.Failure
import com.example.randomjoke.presentation.*

sealed class CommonItem<E>: Mapper<CommonUiModel<E>>{

    class Success<E>(
        private val id:E,
        private val firstText: String,
        private val secondText: String,
        private val favorite: Boolean
    ): CommonItem<E>(){
        override fun to(): CommonUiModel<E> {
            return if (favorite){
                FavoriteCommonUiModel(id,firstText,secondText)
            } else {
                BaseCommonUiModel(firstText,secondText)
            }
        }

    }

    class Failed<E>(private val failure: Failure) : CommonItem<E>(){
        override fun to(): CommonUiModel<E> {
            return FailedCommonUiModel(failure.getMessage())
        }

    }
}