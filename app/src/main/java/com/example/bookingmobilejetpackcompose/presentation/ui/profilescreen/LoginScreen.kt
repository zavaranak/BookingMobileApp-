package com.example.bookingmobilejetpackcompose.presentation.ui.profilescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomInputField
import com.example.bookingmobilejetpackcompose.presentation.ui.Logo
import com.example.bookingmobilejetpackcompose.presentation.utils.Client
import com.example.bookingmobilejetpackcompose.presentation.utils.clientSample

@Composable
fun LoginScreen(logIn:(Client)->Unit){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    CustomColumnContainer {
        Box(modifier = Modifier.padding(bottom = 80.dp, top = 40.dp)){
            Logo()
        }
        Box(modifier = Modifier.fillMaxWidth(0.6f).height(80.dp)){
            CustomInputField(fieldName = "Логин", value = username, onChange = { username = it },type ="text")
        }
        Box(modifier = Modifier.fillMaxWidth(0.6f).height(80.dp)){
            CustomInputField(fieldName = "Пароль", value = password, onChange = { password = it },type ="password")
        }
        Box(modifier = Modifier.height(100.dp))
        Box(modifier = Modifier.fillMaxWidth(0.6f)){
            ThemeButton(name = "Войти",size="normal",color="bold", onClick ={logIn(clientSample)} )
        }
        Box(modifier = Modifier.fillMaxWidth(0.6f)){
            ThemeButton(name = "Создать новый логин",size="normal",color="filled", onClick ={} )
        }
    }

}