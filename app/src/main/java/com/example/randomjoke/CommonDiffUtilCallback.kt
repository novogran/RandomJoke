package com.example.randomjoke

import androidx.recyclerview.widget.DiffUtil
import com.example.randomjoke.presentation.CommonUiModel

class CommonDiffUtilCallback<E>(
    private val olbList: List<CommonUiModel<E>>,
    private val newList: List<CommonUiModel<E>>
) : DiffUtil.Callback() {
    override fun getOldListSize() = olbList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return olbList[oldItemPosition].same(newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = false
}