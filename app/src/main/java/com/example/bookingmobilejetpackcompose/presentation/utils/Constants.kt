package com.example.bookingmobilejetpackcompose.presentation.utils


data class Property(
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
    val tel:String,
    val email:String
)

val Routes = listOf("search","list","profile","notifications")
val Labels = listOf("Поиск","Список","Профиль","Уведомление")
val ownerSample = Owner(
    tel="+78889991222",
    email = "landlord@email.com"
)
val propertySample = Property(
    "haha",
    "hihi ulisa, tomsk",
    1000f,
    "https://example.com/image.jpg",
    true,
    "описаниееееееееееееееееееееееееееееееееееееееееееееееееееееееее",
    arrayOf("","",""),
    arrayOf("парковка", "завтрак", "уборка", "кухня"),
    ownerSample
)