package com.haxon.quotescomposeapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.haxon.quotescomposeapp.models.Quote

@Composable
fun QuoteList(data: List<Quote>, onClick: (quote: Quote) -> Unit) {

    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it, onClick)
        }
    })

}