package com.example.randomjoke

import com.example.randomjoke.presentation.JokeApp

class JokesFragment: BaseFragment<Int>() {

    override fun getViewModel(app: JokeApp) = app.jokeViewModel

    override fun getCommunication(app: JokeApp) = app.jokeCommunication

    override fun checkBoxText() = R.string.show_favorite_joke

    override fun actionButtonText() = R.string.get_joke
}