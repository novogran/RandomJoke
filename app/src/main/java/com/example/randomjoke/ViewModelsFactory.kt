package com.example.randomjoke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

class ViewModelsFactory(
    private val mainModule: MainModule,
    private val jokesModule: JokesModule,
    private val quoteModule: QuotesModule
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val module = when {
            modelClass.isAssignableFrom(MainModule::class.java) -> mainModule
            modelClass.isAssignableFrom(JokeViewModel::class.java) -> jokesModule
            modelClass.isAssignableFrom(QuoteViewModel::class.java) -> quoteModule
            else -> throw IllegalStateException("unknown type of viewModel")
        }
        return module.getViewModel() as T
    }
}