package com.example.bookingmobilejetpackcompose.presentation.api

import com.example.bookingmobilejetpackcompose.presentation.utils.Property
import com.example.bookingmobilejetpackcompose.presentation.utils.propertySample
import kotlinx.coroutines.delay


suspend fun getPopularSearches() : List<String>{
    delay(200)
    val response = listOf("Томск", "Кемерово", "Казань", "Новосибирск", "Тюмень")
    return response
}

suspend fun getResults(location:String,startTimeStamp:Int,endTimeStamp:Int, guestNumber:Int) : Array<String>{
    delay(200)
    val response:Array<String> = if (location!="" && startTimeStamp!=0 && endTimeStamp !=0 && guestNumber >0) {
        arrayOf("abc","xzx","asd","aaa","aad","daf","afx","add")
    }
    else{
        arrayOf("")
    }
    return response
}

suspend fun getPropertyById(id:String) : Property?{
    delay(200)
    val response:Property? = if (id!="") propertySample
        else null
    return response
}