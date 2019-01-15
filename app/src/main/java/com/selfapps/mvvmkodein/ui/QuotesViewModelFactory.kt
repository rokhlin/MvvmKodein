package com.selfapps.mvvmkodein.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.selfapps.mvvmkodein.db.QuoteRepository

/**
 * ViewModelFactory will be instantiated with ViewModel of the current Activity or Fragment
 */
class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(quoteRepository) as T
    }
}