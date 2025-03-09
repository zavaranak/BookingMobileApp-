package com.example.bookingmobilejetpackcompose.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bookingmobilejetpackcompose.presentation.store.BookingViewModel
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeTextOutline
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.R
import com.example.bookingmobilejetpackcompose.presentation.utils.Property
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.ui.ScrollableColumn
import com.example.bookingmobilejetpackcompose.presentation.ui.listscreen.FilterMenu
import com.example.bookingmobilejetpackcompose.presentation.ui.listscreen.PropertyImageFitWidth
import com.example.bookingmobilejetpackcompose.presentation.ui.listscreen.ProperyScreen
import com.example.bookingmobilejetpackcompose.presentation.utils.propertySample
import com.example.bookingmobilejetpackcompose.presentation.utils.propertySample2


@Composable
fun ListScreen(navController: NavController,viewModel:BookingViewModel){
    var selectedProperty by remember { mutableStateOf<Property?>(null) }
    if(selectedProperty!=null){
        ProperyScreen(selectedProperty,viewModel){selectedProperty=null}
    }
    if(selectedProperty==null){
        CustomColumnContainer {
            TopBar(viewModel.bookingState.location)
            ScrollableColumn {
                PropertyCard(id="1"){selectedProperty=it}
                PropertyCard(id="2"){selectedProperty=it}
            }
        }
    }

}

@Composable
fun TopBar(location:String){
    var openFilter by remember { mutableStateOf(false)}

    if(openFilter){
        FilterMenu({openFilter=false},{})
    }
    Row(
        modifier = Modifier.fillMaxWidth(0.9f).padding(top = 5.dp, bottom = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.weight(0.5f).fillMaxWidth()){
            ThemeButton("Фильтрация","small","bold") {openFilter=true}
        }
        Box(modifier = Modifier.weight(0.3f))
        Box(modifier = Modifier.weight(0.2f).fillMaxWidth()){
            ThemeTextOutline(location )
        }
    }
}



@Composable
fun PropertyCard(id:String,setSelectedProperty:(Property)->Unit){
    val property = if(id=="1") propertySample else propertySample2
    Column (
        modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(modifier = Modifier.fillMaxWidth().height(150.dp)){
            PropertyImageFitWidth(property.imgSrc, R.drawable.property)
        }
        Box(modifier = Modifier.fillMaxWidth()){
            Column {
                ThemeText(property.name,"normal","primary")
                ThemeText(property.address,"small","black")
                if(property.bargain){
                    ThemeText("Торг","normal","bold")
                }
            }
        }
        Box(modifier = Modifier.fillMaxWidth(0.9f)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(15.dp)){
                Box(Modifier.weight(1f)){
                    ThemeTextOutline(property.price.toString()+" руб.")
                }
                Box(Modifier.weight(1f)){
                    ThemeButton("Подробнее","small","filled"){
                        setSelectedProperty(property)
                    }
                }

            }
        }
    }
}