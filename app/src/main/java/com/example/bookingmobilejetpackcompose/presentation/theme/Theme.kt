package com.example.bookingmobilejetpackcompose.presentation.theme

import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)


@Composable
fun BookingMobileJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun ThemeButton(name:String,size:String?,color:String, onClick: (()->Unit)?){
    val _fontSize = calFontSize((size))
    val _colors = setColors(color)
//    val
    Button(
        onClick={if(onClick!=null)onClick()},
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(1.dp, _colors.contentColor),
                shape = RoundedCornerShape(50.dp)
            ),
        colors = _colors,

        ) {
        Text(text=name,fontSize=_fontSize)
    }
}

fun calFontSize(size:String?): TextUnit{
    when (size) {
        "super"-> return 40.sp
        "big" -> return 20.sp
        "small" -> return 15.sp
        else -> {
            return 18.sp
        }
    }
}

@Composable
fun setColors(color:String):ButtonColors{
    when(color){
        "dark"->{
            return ButtonColors(
                containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary
            )
        }
        "light"->{
            return ButtonColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary
            )
        }
        "filled"->{
            return ButtonColors(
                containerColor = Purple40,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary
            )
        } 
        "bold"->{
            return ButtonColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary
            )
        }
        "red"->{
            return ButtonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary
            )
        }
        else ->{
            return ButtonColors(
                containerColor = Purple40,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.onSecondary,
                disabledContainerColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun ThemeOutlineTextField(value:String,handleChange:(String)->Unit, type:String, leaddingIcon: (@Composable ()->Unit)?){
    OutlinedTextField(
        value = value,
        onValueChange = {  handleChange(it) },
        leadingIcon = leaddingIcon,
        modifier = Modifier
            .fillMaxSize()
            .border(BorderStroke(2.dp, color = Purple40), shape = RoundedCornerShape(10.dp)),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(keyboardType =
            if (type=="number") KeyboardType.Number
            else if (type =="password" ) KeyboardType.Password
            else KeyboardType.Text ),
        singleLine = true,
        maxLines = 1,
        visualTransformation = if (type == "password") PasswordVisualTransformation() else VisualTransformation.None
//        textStyle = LocalTextStyle.current.copy(fontSize = 14.sp)
    )
}

@Composable
fun ThemeTextOutline(text:String){
    Box(
        modifier = Modifier.border(1.dp,Purple40,shape = RoundedCornerShape(10.dp)).fillMaxWidth(),
    ){
        Text(text, color = Purple40, textAlign = TextAlign.Center, modifier = Modifier.align(
            Alignment.Center).padding(10.dp))
    }
}
@Composable
fun ThemeText(text:String, size:String, color:String){
    val _color:Color = setTextColor(color)
    val _fontSize:TextUnit = calFontSize(size)
    Text(text, color = _color, textAlign = TextAlign.Center, fontSize = _fontSize)
}

@Composable
fun setTextColor(color:String):Color{
    when (color){
        "primary"->{
            return Purple40
        }
        "black" -> {
            return Color.Black
        }
        "bold" -> {
            return MaterialTheme.colorScheme.onPrimaryContainer
        }
        else ->{
            return Purple40
        }
    }
}