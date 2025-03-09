package com.example.bookingmobilejetpackcompose.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bookingmobilejetpackcompose.presentation.store.AuthViewModel
import com.example.bookingmobilejetpackcompose.presentation.ui.profilescreen.ClientScreen
import com.example.bookingmobilejetpackcompose.presentation.ui.profilescreen.LoginScreen

@Composable
fun ProfileScreen(navController: NavController, authViewModel:AuthViewModel){
    val authState = authViewModel.authState
    when(authState.isAuthenticated){
        true->{
            if (authState.client!=null){
                ClientScreen(authState.client,logOut=authViewModel::logOut)
            }
        }
        false->{
            LoginScreen(logIn=authViewModel::logIn)
        }
    }
}