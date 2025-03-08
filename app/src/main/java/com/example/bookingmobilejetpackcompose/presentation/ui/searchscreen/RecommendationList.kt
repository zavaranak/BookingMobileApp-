package com.example.bookingmobilejetpackcompose.presentation.ui.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.bookingmobilejetpackcompose.presentation.api.getPopularSearches
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.Slogan
import kotlinx.coroutines.async

@Composable
fun RecommendationList(onCloseDialog:()->Unit,onSelectLocation:(String)->Unit){
    val popularSearches = remember{ mutableListOf<String>() }
    var loading by remember{ mutableStateOf(true) }
    LaunchedEffect(Unit) {
        loading = true
        val fetch = async { getPopularSearches() }
        val result = fetch.await()
        popularSearches.clear()
        popularSearches.addAll(result)
        loading = false
    }
    Dialog(
        onDismissRequest = { onCloseDialog() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            CustomColumnContainer {
                Box(
                    modifier = Modifier.padding(50.dp)
                ){
                    Slogan("Выберите город")
                }
                if (loading) {
                    ThemeButton("Loading...","normal","filled",null)
                } else {
                    popularSearches.forEach { search ->
                        Box(modifier = Modifier.fillMaxWidth(0.8f).padding(10.dp)){
                            ThemeButton(search,"normal","filled"){onSelectLocation(search);onCloseDialog()}
                        }
                    }
                }
                Box(modifier = Modifier.fillMaxWidth(0.8f).padding(10.dp)){


                    ThemeButton("Закрыть.","normal","dark"){onCloseDialog()}
                }

            }
        }
    }
}