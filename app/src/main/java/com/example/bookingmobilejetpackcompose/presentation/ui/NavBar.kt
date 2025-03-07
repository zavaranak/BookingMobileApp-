package com.example.bookingmobilejetpackcompose.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.bookingmobilejetpackcompose.presentation.theme.Purple40
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.bookingmobilejetpackcompose.presentation.utils.Labels
import com.example.bookingmobilejetpackcompose.presentation.utils.Routes

@Composable
fun NavBar(navController: NavController) {
    var selectedItem by remember{ mutableIntStateOf(1)}
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.List, Icons.Filled.Person, Icons.Filled.Notifications)
    val unselectedIcons = listOf(Icons.Outlined.Home, Icons.Outlined.List, Icons.Outlined.Person, Icons.Outlined.Notifications)

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = Purple40,
        modifier = Modifier.fillMaxWidth()
    ) {
        Labels.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item
                    )

                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(Routes[index])
                }
            )
        }
    }
}
