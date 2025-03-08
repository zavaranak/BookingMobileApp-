package com.example.bookingmobilejetpackcompose.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bookingmobilejetpackcompose.presentation.ui.NavBar


@Composable
fun Layout(navController: NavController ,content: @Composable () -> Unit){
    Scaffold(
        bottomBar = { NavBar(navController) }
    ) {
        paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ){
            content ()
        }
    }
}


