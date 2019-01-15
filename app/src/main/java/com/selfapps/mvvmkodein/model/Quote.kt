package com.selfapps.mvvmkodein.model

class Quote(val text: String,
            val author: String) {

    override fun toString(): String {
        return "$text' - '$author"
    }
}