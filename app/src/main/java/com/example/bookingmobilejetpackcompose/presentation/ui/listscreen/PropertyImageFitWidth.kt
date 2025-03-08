package com.example.bookingmobilejetpackcompose.presentation.ui.listscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun PropertyImageFitWidth(imgSrc:String?,onError:Int){
    AsyncImage(
        model = imgSrc,
        contentDescription = "property image",
        error = painterResource(id = onError),
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
}