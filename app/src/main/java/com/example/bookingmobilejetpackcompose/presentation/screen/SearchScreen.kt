package com.example.bookingmobilejetpackcompose.presentation.screen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.example.bookingmobilejetpackcompose.presentation.ui.Logo
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookingmobilejetpackcompose.presentation.store.BookingViewModel
import com.example.bookingmobilejetpackcompose.presentation.ui.Slogan
import com.example.bookingmobilejetpackcompose.presentation.store.Date
import com.example.bookingmobilejetpackcompose.presentation.theme.Purple40
import com.example.bookingmobilejetpackcompose.presentation.ui.CustomColumnContainer
import java.util.Calendar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.bookingmobilejetpackcompose.presentation.ui.searchscreen.RecommendationList
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeButton
import com.example.bookingmobilejetpackcompose.presentation.theme.ThemeOutlineTextField
import com.example.bookingmobilejetpackcompose.presentation.utils.Routes


@Composable
fun SearchScreen(navController: NavController,viewModel:BookingViewModel) {
    var showList by remember { mutableStateOf(false) }
    CustomColumnContainer {
        Box(modifier = Modifier.padding(bottom = 80.dp, top = 40.dp)){
            Logo()
        }
        Slogan("Ищи свое место")
        InputForm(viewModel)
        Box(modifier = Modifier.fillMaxWidth(0.8f)){

        ThemeButton(name = "Поиск",size="big", color="light" ,{navController.navigate(Routes[1])})
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 40.dp)
        ){
            ThemeButton(name = "Самые популярные поиски",size="normal",color="dark") { showList=true}
        }
        if(showList)
        {
            RecommendationList ({showList=false},viewModel::updateLocation)
        }
    }
}


@Composable
fun InputForm(viewModel: BookingViewModel) {
    val state = viewModel.bookingState
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp)
        ){
        ThemeOutlineTextField(value =  state.location, type = "text", leaddingIcon = {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location Icon"
            )
        }, handleChange = { viewModel.updateLocation(it) })
        }
        DateInput("Начало:",state.startDate,viewModel::updateDateStart)
        DateInput("Конец:",state.endDate,viewModel::updateDateEnd)
        GuestInput("Гости:",state.guestNumber,viewModel::updateGuestNumber)
    }
}
@Composable
fun GuestInput(name:String,guestState: Int,onGuestChange: ((Int) -> Unit)) {
    var tempGuest by remember{ mutableStateOf(guestState.toString())}
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        val outlineModifier = Modifier
            .width(50.dp)
            .padding(0.dp)
            .height(50.dp)
            .wrapContentWidth()
            .align(Alignment.CenterVertically)
            .weight(1f)
            .border(BorderStroke(1.dp, color = Purple40), shape = RoundedCornerShape(10.dp))
        Text(
            name, textAlign = TextAlign.End, modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Box(
            modifier = Modifier.weight(1f),
        ) {
            OutlinedTextField(
                value = tempGuest,
                onValueChange = {
                    val newVal = it.toIntOrNull()
                    tempGuest = it
                    if (newVal!=null){
                        onGuestChange(newVal)
                    }

                },
                modifier = outlineModifier,
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                maxLines = 1,
            )
        }
    }}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateInput(name: String, dateState: Date?, onDateChange: ((Date) -> Unit)) {
        var showDatePicker by remember { mutableStateOf(false) }
        val datePickerState = rememberDatePickerState()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                name, textAlign = TextAlign.End, modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                style = TextStyle(color = Purple40)
            )
            Box(
                modifier = Modifier.weight(1f)
            ) {
                if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { },
                    confirmButton = {
                        TextButton(onClick = {
                            val selectedDateMillis = datePickerState.selectedDateMillis
                            if (selectedDateMillis != null) {
                                val calendar = Calendar.getInstance()
                                calendar.timeInMillis = selectedDateMillis
                                val year = calendar.get(Calendar.YEAR)
                                val month = calendar.get(Calendar.MONTH) + 1
                                val day = calendar.get(Calendar.DAY_OF_MONTH)
                                val selectedDate = Date(day, month, year)
                                onDateChange(selectedDate)
                            }
                            showDatePicker = false
                        }) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {   showDatePicker = false }) {
                            Text("Cancel")
                        }
                    }
                ) {
                    DatePicker(
                        state = datePickerState,

                    )
                }}
                Button(
                    onClick = { showDatePicker = true },
                    modifier = Modifier
                        .width(120.dp)
                        .border(
                            BorderStroke(1.dp, color = Purple40),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Purple40
                    ),
                ) {
                    Text(text = dateState?.toString() ?: "выбрать")
                }
            }
        }
    }
