package com.example.bookingmobilejetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.bookingmobilejetpackcompose.presentation.theme.BookingMobileJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookingMobileJetpackComposeTheme{
                Box(modifier = Modifier.fillMaxSize()){
                   Application()
                }
            }
        }
    }
}


