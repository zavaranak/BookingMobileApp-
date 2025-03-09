package com.example.bookingmobilejetpackcompose.presentation.ui.notificationscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.utils.notificationSample

@Composable
fun NotifcationBox(id:String){
    val notification = if (id !="") notificationSample else null
    if (notification !=null)
    {
        Column (modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background).padding(top = 20.dp)) {
            ThemeText(notification.label,"big","bold")
            ThemeText(notification.description,"small","primary")
        }
    }
}