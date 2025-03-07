package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bookingmobilejetpackcompose.presentation.theme.Purple40

@Composable
fun Logo(){
    Box{
        Text(text="ХОМСК", color = Purple40, fontSize = 50.sp, fontWeight = FontWeight.W900)
    }
}
@Composable
fun Slogan(text:String){
    Box{
        Text(text, color = Purple40, fontSize = 35.sp)
    }
}
