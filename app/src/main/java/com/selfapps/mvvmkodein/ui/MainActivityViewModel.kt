package com.selfapps.mvvmkodein.ui

import androidx.lifecycle.ViewModel
import com.selfapps.mvvmkodein.db.QuoteRepository
import com.selfapps.mvvmkodein.model.Quote

/**
 * ViewModel Instance for MainActivity
 */
class MainActivityViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}