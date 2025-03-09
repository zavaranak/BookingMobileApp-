package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

@Composable
fun CustomOutLinedBox(content: @Composable ()->Unit ){
    val modifier = Modifier.fillMaxWidth(0.9f).border(
        BorderStroke(1.dp,MaterialTheme.colorScheme.primary),
    ).padding(5.dp)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        content()
    }
}