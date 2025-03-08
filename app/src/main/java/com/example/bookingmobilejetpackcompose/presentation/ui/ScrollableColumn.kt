package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun ScrollableColumn(content: @Composable ()->Unit){
    val scrollState = rememberScrollState()
    Column (modifier = Modifier.fillMaxSize().verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally){
        content()
    }
}