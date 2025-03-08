package com.example.bookingmobilejetpackcompose.presentation.ui.listscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.ScrollableColumn

@Composable
fun FilterMenu(onCloseDialog:()->Unit,filterHandler:()->Unit ){
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
                Row(
                    modifier = Modifier
                        .padding(top=20.dp)
                        .fillMaxWidth(0.9f)
                    ,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        ThemeButton("закрыть", "normal", "red") { onCloseDialog() }

                    }
                    Box(modifier = Modifier.weight(1f)) {
                        ThemeButton("подтвердть", "normal", "bold") { }
                    }
                }
                FilterBox()
            }
        }
    }
}

@Composable
fun FilterBox(){
    var sliderPosition by remember{ mutableStateOf(2000f..10000f)}
    var openSort by remember{ mutableStateOf(false)}
    val items = listOf("По цене убывающей", "По цене возрастающей")
    var selectedItem by remember { mutableStateOf(items[0]) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp).border(1.dp,MaterialTheme.colorScheme.onPrimaryContainer).fillMaxWidth(0.9f).height(750.dp)
    ){
        Box(
            modifier = Modifier.padding(10.dp)
        ){
        ThemeText("Диапанзон цены за ночь","normal","black")
        }
        RangeSlider(
            modifier = Modifier.fillMaxWidth(0.9f),
            value = sliderPosition,
            steps = 20,
            onValueChange = {range-> sliderPosition = range},
            valueRange = 1000f..20000f
        )
        Row (horizontalArrangement = Arrangement.spacedBy(50.dp), modifier = Modifier.padding(bottom = 20.dp)){
        Text("от " + sliderPosition.start.toInt().toString(), modifier = Modifier.weight(1f), textAlign = TextAlign.End)
        Text("до " +sliderPosition.endInclusive.toInt().toString(),modifier = Modifier.weight(1f))
        }

        ThemeText("сортировка","small", "primary")
        TextButton(onClick = {openSort=true}){
            Text(selectedItem)
            DropdownMenu(expanded = openSort, onDismissRequest = {openSort=false} ) {
            items.forEach { item ->
                DropdownMenuItem(text = { Text(item)},
                    onClick = {
                        selectedItem = item
                        openSort = false
                    }
                ) }
            }
        }
        ScrollableColumn {
            for (i in 0..20){
                var checked by remember { mutableStateOf(false) }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(0.8f)) {
                    Box(modifier = Modifier.weight(0.4f)){
                        Text("вариант "+ i.toString())
                    }
                    Box(modifier = Modifier.weight(0.5f)){
                        Checkbox(
                            checked=checked,
                            onCheckedChange =  {checked = if(checked) false else true},
                        )
                    }

                }
            }
        }
    }
}

