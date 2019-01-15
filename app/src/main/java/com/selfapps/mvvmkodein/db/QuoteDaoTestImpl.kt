package com.selfapps.mvvmkodein.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selfapps.mvvmkodein.model.Quote

/**
 * Test implementation of the {@see QuoteDao} Interface
 * You can implement this interface for your specific case like: testImpl, prodImpl, debugImpl, etc.
 */
class QuoteDaoTestImpl: QuoteDao {


    private val quoteList = mutableListOf<Quote>() //emulates fake DB
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList //notify LiveData is changed
    }

    override fun getQuotes() = quotes as LiveData<List<Quote>>
}