package com.example.bookingmobilejetpackcompose.presentation.store
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.util.Calendar

data class Date(
    val day:Int,
    val month: Int,
    val year: Int
){
    override fun toString(): String {
        val dayStr:String = if(day>9)day.toString() else "0$day"
        val monthStr:String = if(month>9)month.toString() else "0$month"
        return "$dayStr.$monthStr.$year"
    }
    fun toTimestamp(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month-1, day)
        return calendar.timeInMillis
    }
    fun toCalendar(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, day) // Month is 0-based in Calendar
        return calendar
    }
}

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
