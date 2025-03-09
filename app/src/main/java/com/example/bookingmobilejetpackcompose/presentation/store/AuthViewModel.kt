package com.example.bookingmobilejetpackcompose.presentation.store

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bookingmobilejetpackcompose.presentation.utils.Client


data class AuthState(
    val client:Client?,
    val isAuthenticated:Boolean
)
class AuthViewModel:ViewModel(){
    var authState:AuthState by mutableStateOf(
        AuthState(
            client = null,
            isAuthenticated = false
        )
    )
    fun logIn(client:Client){
        authState = authState.copy(
            isAuthenticated = true,
            client = client
        )
    }
    fun logOut(){
        authState = authState.copy(
            isAuthenticated = false,
            client = null
        )
    }
}