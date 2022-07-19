package com.example.randomjoke

import com.example.randomjoke.core.domain.CommonInteractor
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.presentation.BaseViewModel

class JokeViewModel(
    interactor: CommonInteractor<Int>,
    communication: CommonCommunication<Int>
) : BaseViewModel<Int>("jokes",interactor,communication)