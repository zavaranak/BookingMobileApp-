package com.example.bookingmobilejetpackcompose.presentation.ui.listscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bookingmobilejetpackcompose.R
import com.example.bookingmobilejetpackcompose.presentation.store.BookingViewModel
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeText
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeTextOutline
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import com.example.bookingmobilejetpackcompose.presentation.ui.ScrollableColumn
import com.example.bookingmobilejetpackcompose.presentation.ui.TopBar
import com.example.bookingmobilejetpackcompose.presentation.utils.Owner
import com.example.bookingmobilejetpackcompose.presentation.utils.Property


@Composable
fun ProperyScreen(property:Property?,viewModel: BookingViewModel,goBack:()->Unit){
    var currentPage by remember { mutableStateOf("information") }

    fun backToInformationScreen(){
        currentPage = "information"
    }

    fun handleCreateBooking(){
        currentPage = "create_booking"
    }
    fun handleOfferPrice(){
        if (property != null) {
            if(property.bargain){
                currentPage = "offer_price"
            }
        }
    }
    when(currentPage){
        "information" -> if (property!=null ) {
            CustomColumnContainer {
                TopBar (property.name,goBack)
                ImageCarousel(property.imgSrcArray)
                PropertyInfo(property.address,property.description,property.owner,property.service)
                PriceAndAction(property.bargain,property.price, { handleCreateBooking() },
                    { handleOfferPrice() })
            }
        }
        "create_booking"->{
            if (property!=null)
            CreateBookingScreen(propertyId=property.id, bookingState = viewModel.bookingState,goBack = { backToInformationScreen() })
        }
        "offer_price"->{
            if (property!=null)
            OfferPriceScreen(propertyId=property.id, bookingState = viewModel.bookingState,goBack = { backToInformationScreen() })
        }
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel(imageUrls: Array<String>) {
    val pagerState = rememberPagerState(pageCount = { imageUrls.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { page ->
        PropertyImageFitWidth(
            imageUrls[page], onError = R.drawable.property
        )
    }
}

@Composable
fun PropertyInfo(address:String,description:String,owner:Owner,services:Array<String>){
   Column (Modifier
       .fillMaxWidth(0.9f)
       .padding(top = 10.dp)){
       ThemeText(address,"big","primary")
       ThemeText(description,"normal","black")
       ContactAndService(owner,services)
   }
}

@Composable
fun ContactAndService(owner: Owner,services:Array<String>){
    val serviceString:String = services.joinToString(" | ")
    Box(modifier = Modifier
        .background(
            Color(0xFFD9D9D9)
        )
        .border(BorderStroke(1.dp, Color(0xFFD9D9D9)), shape = RoundedCornerShape(20)),
    ){
        Column(
            modifier = Modifier
                .height(250.dp)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            ThemeText(owner.tel,"normal","bold")
            ThemeText(owner.email,"normal","bold")
            ScrollableColumn {
                ThemeText(serviceString,"normal","black")
            }
        }
    }

}

@Composable
fun PriceAndAction(bargain:Boolean,price:Float, handleCreateBooking:()->Unit,handleOfferPrice:()->Unit){
    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(top = 50.dp, bottom = 30.dp)){
    ThemeTextOutline("$price руб. за ночь")
    }
    Row (
        horizontalArrangement =Arrangement.spacedBy(20.dp)
    ){
        if (bargain){
        Box(modifier = Modifier.weight(1f)){
            ThemeButton("предложить цену","small","filled") {
                handleOfferPrice()
            }
        }}
        Box(modifier = Modifier.weight(1f))
        {
            ThemeButton("бронировать","small","bold") {handleCreateBooking()}
        }


    }
}