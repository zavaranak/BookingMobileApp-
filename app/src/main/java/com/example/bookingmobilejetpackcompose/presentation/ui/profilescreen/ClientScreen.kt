package com.example.bookingmobilejetpackcompose.presentation.ui.profilescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomOutLinedBox
import com.example.bookingmobilejetpackcompose.presentation.utils.Client

@Composable
fun ClientScreen(client: Client, logOut:()->Unit){
    CustomColumnContainer {
        CustomOutLinedBox{
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)){
                Box(modifier = Modifier.weight(1f)){
                    ThemeButton(name="Изменить",color="filled", size = "small") { }
                }
                Box(modifier = Modifier.weight(1f)){
                    ThemeButton(name="Выйти",color="dark", size = "small") { logOut()}
                }
            }
            IconButton(onClick = {}, modifier = Modifier.height(50.dp)) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "")
            }
            Column (modifier = Modifier.fillMaxWidth(0.9f)){
                ThemeText(text = client.FIO,size="normal",color="primary")
                ThemeText(text = "Почта: ${client.FIO}",size="normal",color="primary")
                ThemeText(text = "Тел: ${client.tel}",size="normal",color="primary")
            }
        }
    }
}

