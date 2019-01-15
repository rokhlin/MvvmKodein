package com.selfapps.mvvmkodein.db

class DatabaseTestImpl: Database {
    override val quoteDao: QuoteDao = QuoteDaoTestImpl()
}