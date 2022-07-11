package com.example.randomjoke.presentation

import com.example.randomjoke.core.presentation.Communication

class FailedCommonUiModel(private val text: String): CommonUiModel(text, "") {
    override fun text() = text
    override fun getIconResId() = 0
    override fun show(communication: Communication)  =
        communication.showState(
            State.Failed(text(),getIconResId())
        )
}