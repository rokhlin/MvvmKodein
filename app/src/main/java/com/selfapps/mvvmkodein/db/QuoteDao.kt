package com.selfapps.mvvmkodein.db

import androidx.lifecycle.LiveData
import com.selfapps.mvvmkodein.model.Quote

/**
 * Used as unique Interface for Application Dao
 * You should implement this interface for your specific case like: testImpl, prodImpl, debugImpl, etc.
 */
interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>

}