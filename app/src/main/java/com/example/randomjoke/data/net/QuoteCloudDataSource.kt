package com.example.randomjoke.data.net

class QuoteCloudDataSource(private val service: QuoteService) :
    BaseCloudDataSource<QuoteServerModel,String>() {
    override fun getServerModel() = service.getQuote()
}