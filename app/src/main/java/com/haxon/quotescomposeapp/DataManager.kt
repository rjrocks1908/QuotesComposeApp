package com.haxon.quotescomposeapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.haxon.quotescomposeapp.models.Quote

object DataManager {

    var data = emptyList<Quote>()
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    var currentQuote: Quote? = null

    fun loadAssetsFromFile(context: Context) {

        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        isDataLoaded.value = true
        data = gson.fromJson(json, Array<Quote>::class.java).toList()
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }

}