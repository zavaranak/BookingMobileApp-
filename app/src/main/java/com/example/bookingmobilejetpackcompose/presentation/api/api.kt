package com.example.bookingmobilejetpackcompose.presentation.api

import kotlinx.coroutines.delay

suspend fun getPopularSearches() : List<String>{
    delay(200)
    val response = listOf("Томск", "Кемерово", "Казань", "Новосибирск", "Тюмень")
    return response
}