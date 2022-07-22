package com.example.randomjoke

class QuotesFragment: BaseFragment<QuoteViewModel,String>() {

    override fun checkBoxText() = R.string.show_favorite_quote

    override fun actionButtonText() = R.string.get_quote
    override fun getViewModelClass() = QuoteViewModel::class.java
}