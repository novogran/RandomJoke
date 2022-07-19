package com.example.randomjoke

import com.example.randomjoke.core.domain.CommonInteractor
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.presentation.BaseViewModel

class QuoteViewModel(
    interactor: CommonInteractor<String>,
    communication: CommonCommunication<String>
): BaseViewModel<String>("quotes", interactor,communication)