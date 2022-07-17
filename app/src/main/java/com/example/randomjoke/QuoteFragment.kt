package com.example.randomjoke

import com.example.randomjoke.presentation.JokeApp

class QuoteFragment: BaseFragment<String>() {
    override fun getViewModel(app: JokeApp) = app.quoteViewModel

    override fun getCommunication(app: JokeApp) = app.quoteCommunication

    override fun checkBoxText() = R.string.show_favorite_quote

    override fun actionButtonText() = R.string.get_quote
}