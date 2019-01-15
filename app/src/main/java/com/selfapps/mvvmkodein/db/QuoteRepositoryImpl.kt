package com.selfapps.mvvmkodein.db

import com.selfapps.mvvmkodein.model.Quote

/**
 * Test implementation of the {@see QuoteRepository} Interface
 * You can implement this interface for your specific case like: testImpl, prodImpl, debugImpl, etc.
 * Can contain various types of Dao like: DB, Pref, network
 *
 */
class QuoteRepositoryImpl(private val quoteDao: QuoteDao)
    : QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()

}