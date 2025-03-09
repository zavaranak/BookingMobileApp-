package com.example.bookingmobilejetpackcompose.presentation.utils

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

data class Property(
    val id: String,
    val name:String,
    val address: String,
    val price: Float,
    val imgSrc: String,
    val bargain: Boolean,
    val description:String,
    val imgSrcArray: Array<String>,
    val service:Array<String>,
    val owner: Owner
)


data class Owner(
    val id:String,
    val tel:String,
    val email:String
)

data class Client(
    val id:String,
    val username:String,
    val FIO:String,
    val tel: String,
)

data class Notification(
    val id:String,
    val label:String,
    val description:String,
)