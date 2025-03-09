package com.example.bookingmobilejetpackcompose.presentation.utils


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

val Routes = listOf("search","list","profile","notifications")
val Labels = listOf("Поиск","Список","Профиль","Уведомление")
val ownerSample = Owner(
    id="1",
    tel="+78889991222",
    email = "landlord@email.com"
)
val propertySample = Property(
    "1",
    "haha",
    "hihi ulisa, tomsk",
    1000f,
    "https://images.squarespace-cdn.com/content/v1/551d4b4fe4b088e1f808d234/1632831598321-TIOQ37W6QEXV2NE78D65/Jetpackcompose-bloco.png",
    true,
    "описаниееееееееееееееееееееееееееееееееееееееееееееееееееееееее",
    arrayOf("","",""),
    arrayOf("парковка", "завтрак", "уборка", "кухня"),
    ownerSample
)
val propertySample2 = Property(
    "2",
    "fooooooo",
    "barrrr ulisa, tomsk",
    1000f,
    "image.jpg",
    false,
    "описаниееееееееееееееееееееееееееееееееееееееееееееееееееееееее",
    arrayOf("","",""),
    arrayOf("парковка", "завтрак", "уборка", "кухня"),
    ownerSample
)