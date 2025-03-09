package com.example.bookingmobilejetpackcompose.presentation.store
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.bookingmobilejetpackcompose.presentation.utils.Date
import java.util.Calendar


data class BookingState(
    val location: String,
    val guestNumber: Int,
    val startDate: Date,
    val endDate: Date,
)
class BookingViewModel : ViewModel() {

    var bookingState by mutableStateOf(BookingState(
        location = "Томск",
        guestNumber = 1,
        startDate = getCurrentDate(),
        endDate = getCurrentDate()
    ))
        private  set
    fun updateLocation(newLocation: String) {
        bookingState = bookingState.copy(location = newLocation)
    }

    fun updateGuestNumber(guests: Int?) {
        if(guests!= null){
        bookingState = bookingState.copy(guestNumber = guests)
        }
    }

    fun updateDateStart(start: Date) {
        bookingState = bookingState.copy(startDate = start)
    }
    fun updateDateEnd( end: Date) {
        bookingState = bookingState.copy(endDate = end)
    }

}

fun getCurrentDate():Date{
    val calendar = Calendar.getInstance()
    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH) + 1
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    return Date(day, month, year)
}
