package com.selfapps.mvvmkodein.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.selfapps.mvvmkodein.R
import com.selfapps.mvvmkodein.model.Quote
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

/**
 * KodeinAware used as Dependency injection library for the Kotlin
 */
class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein() //instantiating the kodein from the QuotesApplication

    private val viewModelFactory: QuotesViewModelFactory by instance() //getting an instance from kodein

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        // Use ViewModelProviders class to create / get already created MainActivityViewModel
        // for this view (activity) also works for fragments
        val viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainActivityViewModel::class.java)

        // Observing LiveData from the MainActivityViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getQuotes().observe(this, Observer {quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
