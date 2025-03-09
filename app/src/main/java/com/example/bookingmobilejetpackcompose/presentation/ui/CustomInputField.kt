package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeOutlineTextField
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText



@Composable
fun CustomInputField(fieldName:String, value:String, type:String, onChange:(String)->Unit){
    Column {
        ThemeText(fieldName,"small","bold")
        ThemeOutlineTextField(value = value, handleChange = onChange, type =type, null)
    }
}