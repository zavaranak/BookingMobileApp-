package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CustomColumnContainer(content: @Composable () -> Unit){
    Column( modifier = Modifier
        .fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally)
    {
        content()
    }
}
