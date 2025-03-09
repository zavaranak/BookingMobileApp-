package com.example.bookingmobilejetpackcompose.presentation.ui.listscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.bookingmobilejetpackcompose.presentation.store.BookingState
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomInputField
import com.example.bookingmobilejetpackcompose.presentation.ui.TopBar
import com.example.bookingmobilejetpackcompose.presentation.utils.Date
import com.example.bookingmobilejetpackcompose.presentation.utils.dayDifference


@Composable
fun OfferPriceScreen(propertyId:String,goBack:()->Unit, bookingState: BookingState){
    var offer by remember { mutableStateOf("0")}

//    val property = if (propertyId == "1") propertySample else propertySample2
    CustomColumnContainer {
        TopBar(name="Предложить цену",goBack = goBack)
        Box(modifier = Modifier.fillMaxWidth(0.6f).height(80.dp)){
            CustomInputField(fieldName = "Цену за ночь (руб.)", value=offer,type="number", onChange ={offer=it})}

        Box(
          modifier = Modifier.padding(top=40.dp)
        ){
        InfoOfferPrice(start=bookingState.startDate, end = bookingState.endDate, price = offer.toFloatOrNull(), guest = bookingState.guestNumber)
        }

        Box(modifier = Modifier.fillMaxWidth(0.6f).padding(top=100.dp)){
            ThemeButton("Создать бронирование","normal","") { }
        }

    }
}

@Composable
fun InfoOfferPrice(start:Date,end:Date,guest:Int,price:Float?){
    val dayDiff = dayDifference(start,end)
    val totalCharge =  if(price!=null) dayDiff * price else 0
    Column (modifier = Modifier.fillMaxWidth(0.6f)){
        ThemeText(text="Цена за ноч: ${if(price!=null)price else "..."}",size="normal",color="primary")
        ThemeText(text="Выбранный период",size="normal",color="primary")
        ThemeText(text="с $start до $end",size="normal",color="primary")
        ThemeText(text="Количесто готей: $guest",size="normal",color="primary")
        ThemeText(text="Сумма $totalCharge руб. ($dayDiff ноч.)",size="normal",color="primary")
    }


}


