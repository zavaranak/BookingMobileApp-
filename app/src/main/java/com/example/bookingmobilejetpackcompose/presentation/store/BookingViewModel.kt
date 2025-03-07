package com.example.bookingmobilejetpackcompose.presentation.store
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


data class Date(
    val day:Int,
    val month: Int,
    val year: Int
){
    override fun toString(): String {
        val dayStr:String = if(day>9)day.toString() else "0" + day.toString()
        val monthStr:String = if(month>9)month.toString() else "0" + month.toString()
        return "$dayStr.$monthStr.$year"
    }
    fun toValue():Int{
        val dayStr:String = if(day>9)day.toString() else "0" + day.toString()
        val monthStr:String = if(month>9)month.toString() else "0" + month.toString()
        val yearStr:String = year.toString()
        return (dayStr+monthStr+yearStr).toInt()
    }
}

data class BookingState(
    val location: String = "Томск",
    val guestNumber: Int = 1,
    val startDate: Date? =null,
    val endDate: Date? = null
) {
}

class BookingViewModel : ViewModel() {

    var bookingState by mutableStateOf(BookingState())
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
