package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText

@Composable
fun TopBar(name:String,goBack: () -> Unit){
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
        IconButton (onClick = goBack) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        ThemeText(name,"big","primary")
    }
}
