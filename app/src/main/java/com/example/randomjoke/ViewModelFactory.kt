package com.example.randomjoke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

class ViewModelFactory(
    private val jokesModule: JokesModule,
    private val quoteModel: QuotesModule
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val module = when {
            modelClass.isAssignableFrom(JokeViewModel::class.java) -> jokesModule
            modelClass.isAssignableFrom(QuoteViewModel::class.java) -> quoteModel
            else -> throw IllegalStateException("unknown type of viewModel")
        }
        return module.getViewModel() as T
    }
}