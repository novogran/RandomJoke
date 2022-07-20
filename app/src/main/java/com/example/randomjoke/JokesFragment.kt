package com.example.randomjoke

class JokesFragment: BaseFragment<JokeViewModel,Int>() {

    override fun checkBoxText() = R.string.show_favorite_joke

    override fun actionButtonText() = R.string.get_joke

    override fun getViewModelClass() = JokeViewModel::class.java


}