package com.example.bookingmobilejetpackcompose.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bookingmobilejetpackcompose.presentation.store.AuthViewModel
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.ScrollableColumn
import com.example.bookingmobilejetpackcompose.presentation.ui.notificationscreen.NotifcationBox

@Composable
fun NotificationScreen(navController: NavController,authViewModel: AuthViewModel){
    val authState = authViewModel.authState
    CustomColumnContainer {
        ThemeText(text = "Уведомления",size="super",color="bold")
        if(authState.isAuthenticated){
            ScrollableColumn {
                for(i in 0..20)
                {
                    NotifcationBox(id = i.toString())
                }
            }
        }
        else {
            ThemeText("Нет уведомлений","normal","primary")
        }

    }
}