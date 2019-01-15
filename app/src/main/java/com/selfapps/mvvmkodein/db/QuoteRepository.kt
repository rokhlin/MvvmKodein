package com.selfapps.mvvmkodein.db

import androidx.lifecycle.LiveData
import com.selfapps.mvvmkodein.model.Quote

/**
 * Repository interface for whole application
 * You should implement this interface for your specific case like: testImpl, prodImpl, debugImpl, etc.
 * Define all methods these work with data here...
 */
interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}