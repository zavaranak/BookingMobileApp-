package com.example.bookingmobilejetpackcompose.presentation.utils

import com.example.bookingmobilejetpackcompose.presentation.store.Date

fun dayDifference(startDate: Date, endDate: Date): Long {
    val startCalendar = startDate.toCalendar()
    val endCalendar = endDate.toCalendar()

    val startMillis = startCalendar.timeInMillis
    val endMillis = endCalendar.timeInMillis

    val differenceMillis = endMillis - startMillis
    return differenceMillis / (1000 * 60 * 60 * 24) // Convert milliseconds to days
}