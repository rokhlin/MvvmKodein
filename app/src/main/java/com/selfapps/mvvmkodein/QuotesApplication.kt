package com.selfapps.mvvmkodein

import android.app.Application
import com.selfapps.mvvmkodein.db.*
import com.selfapps.mvvmkodein.ui.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseTestImpl() } //You can replace test implementation with real, prod...
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) } //instance() call QuoteDao from instantiated obj

        //It's not a !!!!singleton
        //bind<QuotesViewModelFactory>() with provider {(QuotesViewModelFactory(instance()))}
        bind() from provider {(QuotesViewModelFactory(instance()))} //Using ViewModel provider we can instantiate ViewModelFactory using itself from Activity
     }

}